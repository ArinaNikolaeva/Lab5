package L5_8.GUI;

import L5_8.data.Popular;
import L5_8.data.Group;
import L5_8.data.Mus;
import L5_8.data.NotPopular;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
    private Mus data;
    public MyTableModel(Mus mus){
        this.data = mus;
    }

    @Override
    public int getRowCount() {
        return data.getCount();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return data.getGroup(rowIndex).getName();
            case 1: return data.getGroup(rowIndex).getYear();
            case 2: return data.getGroup(rowIndex).getParticipants();
            case 3: {
                Group p = data.getGroup(rowIndex);
                if(p instanceof Popular){
                    return ((Popular) p).getGanr();
                }else{
                    return ((NotPopular) p).getGanr();
                }
            }
            case 4: {
                Group p = data.getGroup(rowIndex);
                if(p instanceof Popular){
                    return "Популярная";
                }else{
                    return "Не популярная";
                }
            }
        }
        return "default";
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Название группы";
            case 1: return "Год основания";
            case 2: return "Кол-во участников";
            case 3: return "Жанр";
            case 4: return "Популярность";
        }
        return "";
    }

    public void delete(int ind){
        this.data.remove(ind);
        this.fireTableDataChanged();
    }

    public void addPopular(String name, int year, int participants, String ganr) {
        data.add(new Popular(name, year, participants, ganr));
        this.fireTableDataChanged();
    }

    public void addNotPopular(String name, int year, int participants, String ganr) {
        data.add(new NotPopular(name, year, participants, ganr));
        this.fireTableDataChanged();
    }

    public String search(String str){
        return data.search(str);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        boolean f = false;
        switch (columnIndex){
            case 0: data.getGroup(rowIndex).setName((String)aValue);
                    break;
            case 1:
                try{
                    data.getGroup(rowIndex).setYear(Integer.parseInt((String)aValue));
                    break;
                }catch (NumberFormatException e) {
                    break;
                }
            case 2:
                try{
                    data.getGroup(rowIndex).setParticipants(Integer.parseInt((String)aValue));
                    break;
                }catch (NumberFormatException e) {
                    break;
                }
            case 3: {
                Group p = data.getGroup(rowIndex);
                if (p instanceof Popular) {
                    ((Popular) p).setGanr((String) aValue);
                } else {
                    ((NotPopular) p).setGanr((String) aValue);
                }
                break;

            }
            case 4: break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return true;
            case 1: return true;
            case 2: return true;
            case 3: return true;
        }
        return false;
    }
}
