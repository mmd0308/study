import com.hzqing.domain.UserInfo;
import javassist.*;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author hzqing
 * @date 2019-07-07 14:48
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.hzqing.domain.UserInfo");

        System.out.println(ctClass.getName());
        System.out.println(ctClass.getSimpleName());

        // 获取父类
        CtClass superclass = ctClass.getSuperclass();
        System.out.println(superclass);

        // 获取接口
        CtClass[] interfaces = ctClass.getInterfaces();
        for (CtClass anInterface : interfaces) {
            System.out.println(anInterface);
        }

        // 添加新属性
        CtField sexField = CtField.make("private String sex;", ctClass);
        ctClass.addField(sexField);

        // 添加新方法
        CtMethod make = CtMethod.make("public String getSex(){return sex;}", ctClass);
        ctClass.addMethod(make);

        // 使用反射根据修改后的类创建对象，并且调用方法
        Class<?> aClass = ctClass.toClass();
        UserInfo userInfo = (UserInfo) aClass.getConstructor().newInstance();
        // 通过反射给属性赋值
        Field sex = aClass.getDeclaredField("sex");
        sex.setAccessible(true);
        sex.set(userInfo,"男");
        // 通过反射调用方法
        Method getSex = aClass.getMethod("getSex");
        String invoke = (String) getSex.invoke(userInfo, null);
        System.out.println("性别是： " + invoke);
    }
}
