package mainapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuideTest {

    Guide guide = new Guide();

    @Before
    public void setNeveroyatny() {
        Guide.neveroyatniy = "Ты просто невероятен!";
        System.out.println("neveroyatniy = " + Guide.neveroyatniy);
    }


    @Test
    public void isNeveroyatniyTest() throws Exception {
        System.out.print("response = "); Guide.isNeveroyatniy();


    }

    @Test
    public void showGuideTest() throws Exception {


    }

    @After
    public void result() {
        System.out.println("done!");
    }

}