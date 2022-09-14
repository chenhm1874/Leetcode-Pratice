import java.util.Stack;

public class StoQ {
    public static class TwoStackQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;
        public TwoStackQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }
        public void push(int pushInt){
            stackPush.push(pushInt);
            dao();
        }
        public int poll(){
            if(stackPop.empty()&& stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.pop();
        }
        public int peek(){
            if(stackPop.empty()&&stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.peek();
        }
        public void dao(){
            if(!stackPop.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }
}
