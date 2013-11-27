public class MyMap implements SimpleMap {
    String[] table;

    @Override
    public void put(int key, String name) {
        if(key < 0) {
            return;
        }
        if(isEmpty()) {
            table = new String[key];
        }
        if(table.length < key+1) {
            table = growToFit(key);
        }
        table[key] = name;
    }

    @Override
    public String get(int key) {
        if(key < 0 || key > table.length-1) {
            return null;
        }
        return table[key];
    }

    @Override
    public void remove(int key) {
        table[key] = null;
    }

    @Override
    public boolean isEmpty() {
        boolean result = true;
        if(table != null) {
            for(int i = 0; i < table.length; i++) {
                if(table[i] != null) {
                    result = false;
                }
            }
        }
        return result;
    }

    private String[] growToFit(int num) {
        String[] newTable = new String[num+1];
        System.arraycopy(table,0,newTable,0,table.length);
        return newTable;
    }
}
