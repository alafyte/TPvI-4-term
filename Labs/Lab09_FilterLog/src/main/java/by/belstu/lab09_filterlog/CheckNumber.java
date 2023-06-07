    import org.apache.log4j.Logger;

    import jakarta.servlet.*;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import java.io.IOException;


    public class CheckNumber implements Filter {

        private static final Logger LOGGER = Logger.getLogger(Servlet.class);

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
                throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String number = request.getParameter("number");

             if (number == null ){
                 request.getRequestDispatcher("/index.jsp").forward(request, response);
                 filterChain.doFilter(servletRequest, servletResponse);
             }

            try {
                if(Integer.parseInt(number) > 7777){
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                    LOGGER.error("404");

                }
                else{
                    LOGGER.info("OK 200");
                }
            } catch (NumberFormatException | IOException e) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                filterChain.doFilter(servletRequest, servletResponse);
            }


            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
