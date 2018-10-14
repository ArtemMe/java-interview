package chapter_two.tests;

import chapter_two.MyLinkedList;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import org.junit.Before;
import org.junit.Test;

/**
 * Напишите код для разбиения связного списка вокруг значениях, так чтобы все узлы, меньшие х,
 * предшествовали узлам, большим или равным х. Если х содержится в списке,
 * то значениях должны следовать строго после элементов, меньших х (см. далее).
 * Элемент разбивки х может находиться где угодно в �правой части»;
 * он не обязан располагаться между левой и правой частью.
 *
 * Пример:
 *  Ввод: 3->5->8->5->10->2->1 [значение разбивки = 5]
 *  Вывод: 3->1->2->10->5->5->8
 * */
public class Four {

    MyLinkedList list;
    @Before
    public void init(){
        MyLinkedList list = new MyLinkedList();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(1);
    }
    @Test
    public void test1(){
        MyLinkedList list = new MyLinkedList();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(1);
        list.sort(5);
        list.printData();
    }
}
