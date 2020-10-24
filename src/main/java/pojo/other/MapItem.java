package pojo.other;

public class MapItem {
    private int count;
    private int selectionCoins;

    public MapItem() {
    }

    public MapItem(int count, int selectionCoins) {
        this.count = count;
        this.selectionCoins = selectionCoins;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSelectionCoins() {
        return selectionCoins;
    }

    public void setSelectionCoins(int selectionCoins) {
        this.selectionCoins = selectionCoins;
    }

    @Override
    public String toString() {
        return "MapItem{" +
                "count=" + count +
                ", selectionCoins=" + selectionCoins +
                '}';
    }
}
