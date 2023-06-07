package Tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
//суть тега проста: он должен быть унаследовать от TagSupport
//
public class Year extends TagSupport {
    private String myYear;

    public void setMyYear(String myYear) {
        this.myYear = myYear;
    }

    public int doStartTag() {
        try {
            //Выводим год на my.jsp
            pageContext.getOut().println(myYear);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}