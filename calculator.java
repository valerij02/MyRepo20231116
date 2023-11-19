/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;
import java.util.*;
/**
 *
 * @author val2
 */
public class calculator
{

    public static void main(String[] args) {
        
     //Мои исключения
// Класс "пользовательской" ошибки:
class MyException extends Exception{
// Счетчик ошибок:
static int count=0;
// Текст для описания ошибки:
String name;
// Конструктор класса:
    MyException(String name){
count++;
this.name=name;
    }
// Переопределение метода toString():
    public String toString(){
String text="Возникла ошибка!\n";
text+="Описание: "+name+"\n";
text+="Номер ошибки: "+count;
return text;
    }
}
     //END Мои исключения
        
        Scanner sc=new Scanner(System.in);  //Указатель на объект консоли
String text = sc.nextLine();                     //Считывание введённой строки

int num1=0;                            //1-е число
int num2=0;                            //2-е число
int res=0;                             // Результат вычисления арабский
String resR="$";                       // Результат вычисления римский
char si='a';                           //Знак операции
              //Выделение знака операции из введённой строки
char[] cn = text.toCharArray();        //Введённая строка как массив              
int i=0;                               
    while(i<cn.length){
        if ((cn[i]=='+')||(cn[i]=='-')||(cn[i]=='*')||(cn[i]=='/')) 
        {
        si = cn[i];
        break;
        }
        i++;
        if (i==cn.length) {
        System.out.println("Нет знака операции +-*/");
        }
    }                                  
              //END Выделение знака операции из введённой строки

              //Выделение переменных из введённой строки
StringTokenizer str=new StringTokenizer(text);//Указатель на объект класса StringTokenizer            
String var1=str.nextToken("+-*/");     //Выделение первой переменной-строка  
String var2=str.nextToken("+-*/");     //Выделение второй переменной-строка
String va1=var1.trim();                   //Первая переменная-удаление пробелов из строки
String va2=var2.trim();                   //Вторая переменная-удаление пробелов из строки
              //END Выделение переменных из введённой строки

              //Римские цифры - расчёт
try{                             
if      (                              
        (                                  //Сравнение строк
        (va1.equals("I")==true)||
        (va1.equals("II")==true)||
        (va1.equals("III")==true)||
        (va1.equals("IV")==true)||
        (va1.equals("V")==true)||
        (va1.equals("VI")==true)||
        (va1.equals("VII")==true)||
        (va1.equals("VIII")==true)||
        (va1.equals("IX")==true)||
        (va1.equals("X")==true)
        )
        &&
        (                                 
        (va2.equals("I")==true)||
        (va2.equals("II")==true)||
        (va2.equals("III")==true)||
        (va2.equals("IV")==true)||
        (va2.equals("V")==true)||
        (va2.equals("VI")==true)||
        (va2.equals("VII")==true)||
        (va2.equals("VIII")==true)||
        (va2.equals("IX")==true)||
        (va2.equals("X")==true)
        )                
        )
{                          //Присвоение значений переменным-арабским
    if (va1.equals("I")==true)   {num1=1;}
    if (va1.equals("II")==true)  {num1=2;}
    if (va1.equals("III")==true) {num1=3;}
    if (va1.equals("IV")==true)  {num1=4;}
    if (va1.equals("V")==true)   {num1=5;}
    if (va1.equals("VI")==true)  {num1=6;}
    if (va1.equals("VII")==true) {num1=7;}
    if (va1.equals("VIII")==true){num1=8;}
    if (va1.equals("IX")==true)  {num1=9;}       
    if (va1.equals("X")==true)   {num1=10;}

    if (va2.equals("I")==true)   {num2=1;}
    if (va2.equals("II")==true)  {num2=2;}
    if (va2.equals("III")==true) {num2=3;}
    if (va2.equals("IV")==true)  {num2=4;}
    if (va2.equals("V")==true)   {num2=5;}
    if (va2.equals("VI")==true)  {num2=6;}
    if (va2.equals("VII")==true) {num2=7;}
    if (va2.equals("VIII")==true){num2=8;}
    if (va2.equals("IX")==true)  {num2=9;}       
    if (va2.equals("X")==true)   {num2=10;}
    
    if ((num1<1)||(num1>10)||(num2<1)||(num2>10)) {
    // Генерирование ошибки:
throw new MyException("Неверный формат введённого числа");    
    }
                           //Расчёт результата
    if (si=='+') {res=num1+num2;}
    if (si=='-') {res=num1-num2;}
    if (si=='*') {res=num1*num2;}
    if (si=='/') {res=num1/num2;}
    
    if ((res<1)||(res>10)) {
    // Генерирование ошибки:
throw new MyException("Неверный формат введённого числа");    
    }    
    else {
                           //Присвоение значения результату-римскому
    if (res==1) {resR="I";   }
    if (res==2) {resR="II";  }
    if (res==3) {resR="III"; }
    if (res==4) {resR="IV";  }
    if (res==5) {resR="V";   }
    if (res==6) {resR="VI";  }
    if (res==7) {resR="VII"; }
    if (res==8) {resR="VIII";}
    if (res==9) {resR="IX";  }
    if (res==10) {resR="X";  } 
    
    System.out.println(resR);     //Вывод на консоль результата-римский
    }  //END else
}             //END //Присвоение значений переменным-арабским
                 //END Римские цифры - расчёт
else {
                 
                 //Арабские цифры - расчёт
   
num1=Integer.parseInt(va1);    //Получение числа из строки
num2=Integer.parseInt(va2);    //Получение числа из строки             
                    //Получение результата-арабские
    if (si=='+') {res=num1+num2;}
    if (si=='-') {res=num1-num2;}
    if (si=='*') {res=num1*num2;}
    if (si=='/') {res=num1/num2;}

System.out.println(res);        //Вывод результата на консоль

}   //END else
                 //END Арабские цифры - расчёт 
}    //END try
catch(ArithmeticException eObj){
System.out.println("\nОшибка: деление на ноль! Описание: "+eObj);
}
catch(MyException obj){ // Обработка ошибки
System.out.println(obj);
}
}
}

