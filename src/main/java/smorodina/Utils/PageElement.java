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

//    private static String lastInitialized;
//    private static Class lastInitClass;

//    public void initPage(String pageName) throws Exception {
//        Set<Class<?>> annotated =
//                new Reflections("src/main/java/smorodina/pages/").getTypesAnnotatedWith(AbstractPageInGeneralFrame.class);
//
//        for (Class classToInit : annotated) {
//            AbstractPageInGeneralFrame annotation = (AbstractPageInGeneralFrame) classToInit.getAnnotation(AbstractPageInGeneralFrame.class);
//            if (annotation.name().equals(pageName)) {
//                classToInit.newInstance();
//                lastInitialized = substringAfter(classToInit.toString(), "class ");
//                lastInitClass = classToInit;
//                return;
//            }
//        }
//
////        throw new AutotestError("Could not find page to init: " + pageName);
//    }

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
