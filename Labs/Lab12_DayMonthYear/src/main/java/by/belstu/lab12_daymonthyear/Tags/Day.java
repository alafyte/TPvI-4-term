package Tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Day extends TagSupport  {
    //private static final long serialVersionUID = 1L;
    private String myDay;

    public void setMyDay(String myDay) {
        this.myDay = myDay;
    }

    public int doStartTag() throws JspException {
        try {
            //Выводим день на my.jsp
            pageContext.getOut().println(this.myDay);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }


}
