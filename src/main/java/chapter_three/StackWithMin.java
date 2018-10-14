package chapter_three;

public class StackWithMin extends MyStack<Integer> {

    MyStack s2 = new MyStack();

    @Override
    public Integer pop() {
        int val = super.pop();

        if(val == (int) s2.peek())
            s2.pop();

        return val;
    }

    @Override
    public void push(Integer item) {
        if(s2.isEmpty() || item <= (int) s2.peek()){
            s2.push(item);
        }
        super.push(item);
    }

    public int getMinValue() {
        return (int) s2.peek();
    }
}
