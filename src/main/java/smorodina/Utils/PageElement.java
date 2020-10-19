package smorodina.Utils;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

import static com.codeborne.selenide.Selenide.page;


public class PageElement {

    private static SelenideElement element = null;

    private static void findElementByTitle(String clazz, String elementName) throws IllegalAccessException, ClassNotFoundException {
        boolean elementFound = false;
        Class<?> aClass = Class.forName("smorodina.pages." + clazz);
        Field[] fields = aClass.getDeclaredFields();
//        Set<Field> annotated = new Reflections(aClass,new FieldAnnotationsScanner()).getFieldsAnnotatedWith(NameTag.class);

        for (Field field : fields) {
            try {
                NameTag annotation = field.getAnnotation(NameTag.class);
                if (annotation.name().equals(elementName)) {
                    field.setAccessible(true);
                    elementFound = true;
                    element = (SelenideElement) field.get(page(aClass));
                    break;
                }
            } catch (NullPointerException ignored) {
            }
        }
        Assert.assertTrue("Элемент с таким название не найден на странице!", elementFound);
    }

    public static SelenideElement getElement(String clazz, String elementName) throws ClassNotFoundException, IllegalAccessException {
        findElementByTitle(clazz, elementName);
        return element;
    }
}
