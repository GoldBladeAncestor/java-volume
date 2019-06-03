package com;

import com.clone.Address;
import com.clone.Customer;
import org.junit.Test;

import java.io.*;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 12:28 2019/5/15
 */
public class TestClone {
    public  static void main(String args[]) throws Exception{
        WeeklyLog log_previous = new WeeklyLog();  //创建原型对象
        log_previous.setName("张无忌");
        log_previous.setDate("第12周");
        log_previous.setContent("这周工作很忙，每天加班！");
        Attachment  attachment = new Attachment(); //创建附件对象
        log_previous.setAttachment(attachment);  //将附件添加到周报中

        System.out.println("****周报****");
        System.out.println("周次：" +  log_previous.getDate());
        System.out.println("姓名：" +  log_previous.getName());
        System.out.println("内容：" +  log_previous.getContent());
        System.out.println("--------------------------------");

        WeeklyLog  log_new;
        log_new  = log_previous.deepClone(); //调用克隆方法创建克隆对象
        log_new.setDate("第13周");
        System.out.println("****周报****");
        System.out.println("周次：" + log_new.getDate());
        System.out.println("姓名：" + log_new.getName());
        System.out.println("内容：" + log_new.getContent());

        System.out.println(log_previous == log_new);
        System.out.println(log_previous.getDate() == log_new.getDate());
        System.out.println(log_previous.getName() == log_new.getName());
        System.out.println(log_previous.getContent() == log_new.getContent());
        System.out.println(log_previous.getAttachment() == log_new.getAttachment());

    }

    @Test
    public void testClone() throws IOException, ClassNotFoundException {
        Customer customer = new Customer();
        customer.setAddress(new Address());
        customer.setName("123");

        Customer copy = customer.clone();

        System.out.println(customer == copy);
        System.out.println(customer.getAddress() == copy.getAddress());
        System.out.println(customer.getName() == copy.getName());

        Customer copyDeep = customer.deepClone();

        System.out.println(customer == copyDeep);
        System.out.println(customer.getAddress() == copyDeep.getAddress());
        System.out.println(customer.getName() == copyDeep.getName());
    }
}

class WeeklyLog implements Cloneable,Serializable{
   private String name;
   private String date;
   private String content;
   private Attachment attachment;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public  void setName(String name) {
              this.name  = name;
       }
       public  void setDate(String date) {
              this.date  = date;
       }
       public  void setContent(String content) {
              this.content  = content;
       }
       public  String getName() {
              return  (this.name);
       }
       public  String getDate() {
              return  (this.date);
       }
       public  String getContent() {
              return  (this.content);
       }
     //克隆方法clone()，此处使用Java语言提供的克隆机制
               public WeeklyLog clone()
       {
              Object obj = null;
              try
              {
                     obj = super.clone();
                     return (WeeklyLog)obj;
              }
              catch(CloneNotSupportedException e)
              {
                     System.out.println("不支持复制！");
                     return null;
              }
       }
    //使用序列化技术实现深克隆
       public WeeklyLog deepClone() throws IOException, ClassNotFoundException, OptionalDataException
       {
              //将对象写入流中
              ByteArrayOutputStream bao=new ByteArrayOutputStream();
              ObjectOutputStream oos=new ObjectOutputStream(bao);
              oos.writeObject(this);

              //将对象从流中取出
              ByteArrayInputStream bis=new  ByteArrayInputStream(bao.toByteArray());
              ObjectInputStream ois=new  ObjectInputStream(bis);
              return  (WeeklyLog)ois.readObject();
       }

}
class  Attachment implements Serializable
        {
               private  String name; //附件名
               public  void setName(String name)
               {
                      this.name  = name;
               }
               public  String getName()
               {
                      return  this.name;
               }
             public void download()
             {
                    System.out.println("下载附件，文件名为" + name);
             }
        }

