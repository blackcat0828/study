package Study;

public class HttpServletExample {
    public static void method(HttpServlet servlet){
        servlet.service();
    }

    public static void main(String[] args) {
            method(new LoginServlet());
            method(new FileDownloadServlet());

    }
}
