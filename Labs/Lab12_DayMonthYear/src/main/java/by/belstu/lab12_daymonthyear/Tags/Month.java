package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

public class Month extends TagSupport {
    private String myMonth;

    public void setMyMonth(String myMonth) {
        this.myMonth = myMonth;
    }

    public int doStartTag() throws JspException {
        try {
            //Выводим месяц на my.jsp
            pageContext.getOut().println(myMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }


}

