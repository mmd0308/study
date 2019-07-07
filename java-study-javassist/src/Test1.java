import javassist.*;

public class Test1 {

    public static void main(String[] args) throws Exception {

        ClassPool classPool = ClassPool.getDefault();
        // 创建一个User类
        CtClass ctClass = classPool.makeClass("com.hzqing.domain.UserInfo");

        // 在类中添加字段
        CtField ageField = CtField.make("private int age;", ctClass);
        ctClass.addField(ageField);

        CtField nameField = CtField.make("private String name;", ctClass);
        ctClass.addField(nameField);

        // 在类中添加方法
        CtMethod getAge = CtMethod.make("public int getAge(){return age;}", ctClass);
        ctClass.addMethod(getAge);
        CtMethod getName = CtMethod.make("public String getName(){return name;}", ctClass);
        ctClass.addMethod(getName);

        // 生成一个无参数构造方法
        CtConstructor ctConstructor1 = new CtConstructor(null, ctClass);
        ctClass.addConstructor(ctConstructor1);

        CtConstructor ctConstructor2 = new CtConstructor(new CtClass[]{CtClass.intType},ctClass);
        // $1表示获取第一个参数
        ctConstructor2.setBody("{ this.age = $1;}");
        ctClass.addConstructor(ctConstructor2);

        // 写出到当前目录下面
        ctClass.writeFile();
    }
}
