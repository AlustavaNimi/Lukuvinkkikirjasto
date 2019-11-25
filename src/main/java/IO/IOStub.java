package IO;

import java.util.ArrayList;

public class IOStub implements IO {
    int current = 0;
    ArrayList<String> inputs = new ArrayList<>();
    ArrayList<String> outputs = new ArrayList<>();

    @Override
    public String nextLine() {
        return inputs.get(current++);
    }

    @Override
    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    @Override
    public void print(String output) {
        outputs.add(output);
    }

    @Override
    public void print(Object object) {
        outputs.add(object.toString());
    }
}
