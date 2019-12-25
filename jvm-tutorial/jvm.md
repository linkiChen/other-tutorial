#### 1. 保存内存溢出的快照
1. 模拟内存溢出

   ```java
   public class Entity {
   }
   
   public class OomApplication {
       public static void main(String[] args) {
           final ArrayList<Entity> entities = new ArrayList<Entity>();
           while (true) {
               // 一直向entities中添加元素,直至堆内存用完就会发生
               // 'java.lang.OutOfMemoryError: Java heap space'异常
               entities.add(new Entity());
           }
       }
   }
   ```

   2. 在Idea中配置运行‘OomApplication’的参数(就是保存运行快照),在Run->Edit Configurations的Applications中找到‘OomApplication’(如果没有,可以先运行一次OomApplication),作如下配置：

      VM Opitons: -XX:+HeapDumpOnOutOfMemoryError -Xms20m -Xmx20m，配置完后再运行‘OomApplication’，当发生java.lang.OutOfMemoryError异常后在项目的根目录就会有.hprof后缀的快照文件生成

      ![](E:\workspace\other-tutorial\jvm-tutorial\imgs\oom1.png)

   3. 使用[Eclipse Memory Analyzer]( https://www.eclipse.org/mat/ )工具对快照文件进行分析