package TrabalhoLPO1;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTabelaCliente extends AbstractTableModel {
    private List<Cliente> listaClientes;
    private String[] nomesColunas = {"Nome", "Sobrenome", "RG", "CPF", "Endereço"};

    public ModeloTabelaCliente(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public int getRowCount() {
        return listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public String getColumnName(int indiceColuna) {
        return nomesColunas[indiceColuna];
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        Cliente cliente = listaClientes.get(indiceLinha);
        switch (indiceColuna) {
            case 0: return cliente.getNome();
            case 1: return cliente.getSobrenome();
            case 2: return cliente.getRg();
            case 3: return cliente.getCpf();
            case 4: return cliente.getEndereco();
            default: return null;
        }
    }

    public Cliente getCliente(int indiceLinha) {
        return listaClientes.get(indiceLinha);
    }

    public void setListaClientes(List<Cliente> novaLista) {
        this.listaClientes = novaLista;
        fireTableDataChanged();
    }
}
