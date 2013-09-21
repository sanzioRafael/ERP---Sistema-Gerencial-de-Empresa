/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Rafael
 */
public class TabelaTipoPagamento {
    private Integer cod_tipo_pagamento;
    private String descricao;

    public TabelaTipoPagamento(Integer cod_tipo_pagamento, String descricao) {
        this.cod_tipo_pagamento = cod_tipo_pagamento;
        this.descricao = descricao;
    }

    public int getCod_tipo_pagamento() {
        return cod_tipo_pagamento;
    }

    public void setCod_tipo_pagamento(Integer cod_tipo_pagamento) {
        this.cod_tipo_pagamento = cod_tipo_pagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
