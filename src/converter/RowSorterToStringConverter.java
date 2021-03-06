/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Rafael
 */
public class RowSorterToStringConverter extends Converter {
    
    private JTable table;

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    
    @Override
    public Object convertForward(Object mask) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object convertReverse(Object mask) {
        TableRowSorter sorter = new TableRowSorter(table.getModel());
        /*
         * O seguinte comando torna o filtro case-sensetive, se você
         * quiser o filtro case-sensitive, descomente a linha abaixo
         * e comente as 7 linhas abaixo
         */
        sorter.setRowFilter(RowFilter.regexFilter("." + mask + ".*"));
        /*
         * As seguintes 7 linhas criam um filtro case-sensitive. Se você deseja
         * um filtro case-sensitive, comente essas linhas e descomente a linha acima
         */
        
        String m = mask.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length(); i++) {
            
            char c = m.charAt(i);
            sb.append('[').append(Character.toLowerCase(c)).append(Character.toUpperCase(c)).append(']');
        }
        
        sorter.setRowFilter(RowFilter.regexFilter(".*" + sb + ".*"));
        return sorter;
        
    }
    
}
