    -- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE fornecedor (
    cpf CHAR(11),
    CEP CHAR(8),
    site VARCHAR(100),
    email VARCHAR(50),
    nome VARCHAR(50),
    endereco VARCHAR(100),
    cod_fornecedor SERIAL PRIMARY KEY,
    tipo VARCHAR(14),
    cnpj CHAR(14),
    rg VARCHAR(20),
    bairro VARCHAR(50),
    orgao_expeditor VARCHAR(10),
    UF CHAR(2),
    cidade VARCHAR(50),
    telefone VARCHAR(50)
);

CREATE TABLE cliente_telefone (
    cod_telefone SERIAL PRIMARY KEY,
    tipo_telefone VARCHAR(50),
    num_telefone VARCHAR(50),
    cod_cliente_f SERIAL,
    cod_cliente_j SERIAL,
    FOREIGN KEY(cod_cliente_f) REFERENCES cliente_fisico (cod_cliente_f),
    FOREIGN KEY(cod_cliente_j) REFERENCES cliente_juridico (cod_cliente_j)
);

CREATE TABLE banco (
    gerente VARCHAR(50),
    telefone VARCHAR(100),
    num_conta INTEGER,
    agencia INTEGER,
    cod_banco SERIAL PRIMARY KEY,
    nome varchar(50)
);

CREATE TABLE recebimento (
    cod_recebimento SERIAL PRIMARY KEY,
    num_doc VARCHAR(20),
    vlr_recebido NUMERIC(11,2),
    vlr_multa NUMERIC(11,2),
    vlr_juro NUMERIC(11,2),
    dt_recebimento DATE,
    dt_lancamento DATE,
    vlr_total NUMERIC(11,2),
    dt_emissao DATE,
    dt_vencimento DATE,
    cod_cliente_j SERIAL,
    cod_cliente_f SERIAL,
    cod_tipo_pgto SERIAL,
    cod_banco SERIAL,
    FOREIGN KEY(cod_banco) REFERENCES banco (cod_banco)
);

CREATE TABLE departamento (
    nome VARCHAR(50),
    cod_departamento SERIAL PRIMARY KEY
);

CREATE TABLE unidade (
    descricao VARCHAR(20),
    cod_unidade SERIAL PRIMARY KEY
);

CREATE TABLE pedido_cab (
    vlr_pedido NUMERIC(11,2),
    desconto NUMERIC(11,2),
    total_pedido NUMERIC(11,2),
    endereco_entrega VARCHAR(50),
    endereco_cobranca VARCHAR(50),
    cod_pedido_cab SERIAL PRIMARY KEY,
    dt_pedido DATE,
    cod_fornecedor SERIAL,
    cod_cot_cab SERIAL,
    FOREIGN KEY(cod_fornecedor) REFERENCES fornecedor (cod_fornecedor)
);

CREATE TABLE cot_cab (
    data DATE,
    cod_cot_cab SERIAL PRIMARY KEY,
    forn1 INTEGER,
    forn2 INTEGER,
    forn3 INTEGER,
    forn4 INTEGER,
    forn5 INTEGER,
    cond1 VARCHAR(30),
    cond2 VARCHAR(30),
    cond3 VARCHAR(30),
    cond4 VARCHAR(30),
    cond5 VARCHAR(30),
    entrega1 VARCHAR(30),
    entrega2 VARCHAR(30),
    entrega3 VARCHAR(30),
    entrega4 VARCHAR(30),
    entrega5 VARCHAR(30),
    total2 NUMERIC(11,2),
    total1 NUMERIC(11,2),
    desc1 NUMERIC(11,2),
    desc2 NUMERIC(11,2),
    desc3 NUMERIC(11,2),
    total5 NUMERIC(11,2),
    desc5 NUMERIC(11,2),
    desc4 NUMERIC(11,2),
    total4 NUMERIC(11,2),
    total3 NUMERIC(11,2)
);

CREATE TABLE cot_det (
    qtd_cot_det INTEGER,
    unit1 NUMERIC(5,2),
    unit2 NUMERIC(5,2),
    unit3 NUMERIC(5,2),
    unit4 NUMERIC(5,2),
    unit5 NUMERIC(5,2),
    total1 NUMERIC(11,2),
    total2 NUMERIC(11,2),
    total3 NUMERIC(11,2),
    total4 NUMERIC(11,2),
    total5 NUMERIC(11,2),
    cod_cot_cab SERIAL,
    cod_req_cab SERIAL,
    PRIMARY KEY(cod_cot_cab,cod_req_cab),
    FOREIGN KEY(cod_cot_cab) REFERENCES cot_cab (cod_cot_cab)
);

CREATE TABLE pedido_det (
    qtd_pedido_det INTEGER,
    vlr_unit NUMERIC(5,2),
    vlr_total NUMERIC(11,2),
    cod_pedido_cab SERIAL,
    PRIMARY KEY(qtd_pedido_det,cod_pedido_cab),
    FOREIGN KEY(cod_pedido_cab) REFERENCES pedido_cab (cod_pedido_cab)
);

CREATE TABLE cliete_endereco (
    CEP CHAR(8),
    logradouro VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    UF CHAR(2),
    pais VARCHAR(50),
    complemento VARCHAR(20),
    cod_endereco SERIAL PRIMARY KEY,
    cod_cliente_f SERIAL,
    cod_cliente_j SERIAL,
    FOREIGN KEY(cod_cliente_f) REFERENCES cliente_fisico (cod_cliente_f),
    FOREIGN KEY(cod_cliente_j) REFERENCES cliente_juridico (cod_cliente_j)
);

CREATE TABLE cfop (
    cod_cfop SERIAL PRIMARY KEY,
    descricao TEXT
);

CREATE TABLE cartao (
    cod_cartao SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    taxa NUMERIC(5,2)
);

CREATE TABLE venda_det (
    vlr_total NUMERIC(11,2),
    vlr_unitario NUMERIC(5,2),
    qtd_venda_det INTEGER,
    cod_produto SERIAL,
    cod_venda_cab SERIAL,
    PRIMARY KEY(cod_produto,cod_venda_cab)
);

CREATE TABLE venda_cab (
    valor_venda NUMERIC(11,2),
    dt_venda DATE,
    total_venda NUMERIC(11,2),
    primeiro_venc DATE,
    num_nf INTEGER,
    cod_venda_cab SERIAL PRIMARY KEY,
    valor_desconto NUMERIC (11,2),
    cod_cartao SERIAL,
    cod_funcionario SERIAL,
    cod_cliente_j SERIAL,
    cod_cfop SERIAL,
    cod_tipo_pgto SERIAL,
    cod_cliente_f SERIAL,
    FOREIGN KEY(cod_cartao) REFERENCES cartao (cod_cartao),
    FOREIGN KEY(cod_cfop) REFERENCES cfop (cod_cfop)
);

CREATE TABLE cliente_juridico (
    email VARCHAR(50),
    nome_fantasia VARCHAR(50),
    razao_social VARCHAR(50),
    CNPJ CHAR(14),
    site VARCHAR(100),
    fone_referencia VARCHAR(100),
    referencia VARCHAR(50),
    renda NUMERIC(19,2),
    dt_constituicao DATE,
    insc_estadual VARCHAR(20),
    cod_cliente_j SERIAL PRIMARY KEY,
    representante varchar(50),
    UF CHAR(2)
);

CREATE TABLE cliente_fisico (
    cod_cliente_f SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    email VARCHAR(50),
    dt_nascimento DATE,
    CPF CHAR(11),
    referencia VARCHAR(50),
    RG VARCHAR(20),
    renda NUMERIC(11,2),
    fone_referencia VARCHAR(100)
);

CREATE TABLE tipo_pagamento (
    cod_tipo_pgto SERIAL PRIMARY KEY,
    descricao VARCHAR(20)
);

CREATE TABLE orcamento_cab (
    vlr_orcamento_cab NUMERIC(11,2),
    cod_orcamento_cab SERIAL PRIMARY KEY,
    dt_orcamento_cab DATE,
    cod_cliente_f SERIAL,
    cod_cliente_j SERIAL,
    cod_funcionario SERIAL,
    FOREIGN KEY(cod_cliente_f) REFERENCES cliente_fisico (cod_cliente_f),
    FOREIGN KEY(cod_cliente_j) REFERENCES cliente_juridico (cod_cliente_j)
);

CREATE TABLE funcionario (
    acesso_total CHAR(1),
    senha VARCHAR(20),
    dt_admissao DATE,
    login VARCHAR(10),
    cargo VARCHAR(50),
    cod_funcionario SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    cod_departamento SERIAL,
    FOREIGN KEY(cod_departamento) REFERENCES departamento (cod_departamento)
);

CREATE TABLE orcamento_det (
    vlr_unitario NUMERIC(5,2),
    qtd_orcamento_det INTEGER,
    vlr_total NUMERIC(11,2),
    cod_produto SERIAL,
    cod_orcamento_cab SERIAL,
    PRIMARY KEY(cod_produto,cod_orcamento_cab),
    FOREIGN KEY(cod_orcamento_cab) REFERENCES orcamento_cab (cod_orcamento_cab)
);

CREATE TABLE cobranca (
    cod_cobranca SERIAL PRIMARY KEY,
    assunto VARCHAR(50),
    texto TEXT,
    envio1 DATE,
    envio2 DATE,
    num_processo VARCHAR(30),
    dt_processo DATE,
    advogado VARCHAR(50),
    cod_cliente_f SERIAL,
    cod_cliente_j SERIAL,
    FOREIGN KEY(cod_cliente_f) REFERENCES cliente_fisico (cod_cliente_f),
    FOREIGN KEY(cod_cliente_j) REFERENCES cliente_juridico (cod_cliente_j)
);

CREATE TABLE nfe_cab_cfop (
    num_nfe_cab INTEGER,
    cod_cfop SERIAL,
    PRIMARY KEY(num_nfe_cab,cod_cfop),
    FOREIGN KEY(cod_cfop) REFERENCES cfop (cod_cfop)
);

CREATE TABLE pagamento (
    cod_pagamento SERIAL PRIMARY KEY,
    num_doc_pgto VARCHAR(20),
    vlr_total NUMERIC(11,2),
    vlr_juro NUMERIC(11,2),
    vlr_multa NUMERIC(11,2),
    vlr_desconto NUMERIC(11,2),
    vlr_pago NUMERIC(11,2),
    nominal VARCHAR(50),
    num_cheque INTEGER,
    dt_emissao DATE,
    dt_lancamento DATE,
    dt_vencimento DATE,
    dt_pagamento DATE,
    dt_cheque DATE,
    cod_banco SERIAL,
    cod_plano_conta SERIAL,
    cod_tipo_pgto SERIAL,
    cod_fornecedor SERIAL,
    FOREIGN KEY(cod_banco) REFERENCES banco (cod_banco),
    FOREIGN KEY(cod_tipo_pgto) REFERENCES tipo_pagamento (cod_tipo_pgto),
    FOREIGN KEY(cod_fornecedor) REFERENCES fornecedor (cod_fornecedor)
);

CREATE TABLE plano_conta (
    cod_plano_conta SERIAL PRIMARY KEY,
    descricao VARCHAR(50)
);

CREATE TABLE conciliacao (
    cod_conciliacao SERIAL PRIMARY KEY,
    dt_cheque DATE,
    num_cheque INTEGER,
    vlr_cheque NUMERIC(11,2),
    mes_ano VARCHAR(7),
    historico VARCHAR(50)
);

CREATE TABLE movimento (
    cod_movimento SERIAL PRIMARY KEY,
    mes_ano VARCHAR(7),
    num_cheque INTEGER,
    dt_cheque DATE,
    dt_lancamento DATE,
    historico VARCHAR(50),
    vlr_documento NUMERIC(11,2),
    cod_plano_conta SERIAL,
    FOREIGN KEY(cod_plano_conta) REFERENCES plano_conta (cod_plano_conta)
);

CREATE TABLE cheque_n_comp (
    cod_cheque_n_comp SERIAL PRIMARY KEY,
    num_cheque INTEGER,
    dt_cheque DATE,
    vlr_cheque NUMERIC(11,2),
    mes_ano VARCHAR(7),
    historico VARCHAR(50)
);

CREATE TABLE fechamento (
    cod_fechamento SERIAL PRIMARY KEY,
    mes_ano VARCHAR(7),
    vlr_saldo_anterior NUMERIC(11,2),
    vlr_recebimento NUMERIC(11,2),
    vlr_cheque_n_comp NUMERIC(11,2),
    vlr_saldo_real NUMERIC(11,2),
    vlr_pagamento NUMERIC(11,2),
    vlr_saldo_conta NUMERIC(11,2)
);

CREATE TABLE nfe_det (
    qtde_nfe_det INTEGER,
    vlr_total NUMERIC(11,2),
    vlr_unitario NUMERIC(5,2),
    num_nfe_cab INTEGER,
    cod_produto SERIAL,
    PRIMARY KEY(num_nfe_cab,cod_produto)
);

CREATE TABLE nfe_cab (
    total NUMERIC(11,2),
    dt_entrada DATE,
    dt_emissao DATE,
    num_nfe_cab INTEGER PRIMARY KEY,
    cod_fornecedor SERIAL,
    FOREIGN KEY(cod_fornecedor) REFERENCES fornecedor (cod_fornecedor)
);

CREATE TABLE produto (
    cod_produto SERIAL PRIMARY KEY,
    critico_produto INTEGER,
    valor_venda NUMERIC(9,2),
    estoque_produto INTEGER,
    descricao VARCHAR(50),
    valor_compra NUMERIC(9,2),
    cod_unidade SERIAL,
    cod_fornecedor SERIAL,
    FOREIGN KEY(cod_unidade) REFERENCES unidade (cod_unidade),
    FOREIGN KEY(cod_fornecedor) REFERENCES fornecedor (cod_fornecedor)
);

CREATE TABLE req_det (
    vlr_total NUMERIC(11,2),
    vlr_unitario NUMERIC(5,2),
    qtd_req INTEGER,
    cod_req_cab SERIAL,
    cod_produto SERIAL,
    PRIMARY KEY(cod_req_cab,cod_produto),
    FOREIGN KEY(cod_produto) REFERENCES produto (cod_produto)
);

CREATE TABLE req_cab (
    cod_req_cab SERIAL PRIMARY KEY,
    dt_req DATE,
    cod_funcionario SERIAL,
    FOREIGN KEY(cod_funcionario) REFERENCES funcionario (cod_funcionario)
);

ALTER TABLE recebimento ADD FOREIGN KEY(cod_cliente_j) REFERENCES cliente_juridico (cod_cliente_j);
ALTER TABLE recebimento ADD FOREIGN KEY(cod_cliente_f) REFERENCES cliente_fisico (cod_cliente_f);
ALTER TABLE recebimento ADD FOREIGN KEY(cod_tipo_pgto) REFERENCES tipo_pagamento (cod_tipo_pgto);
ALTER TABLE pedido_cab ADD FOREIGN KEY(cod_cot_cab) REFERENCES cot_cab (cod_cot_cab);
ALTER TABLE cot_det ADD FOREIGN KEY(cod_req_cab) REFERENCES req_cab (cod_req_cab);
ALTER TABLE venda_det ADD FOREIGN KEY(cod_produto) REFERENCES produto (cod_produto);
ALTER TABLE venda_det ADD FOREIGN KEY(cod_venda_cab) REFERENCES venda_cab (cod_venda_cab);
ALTER TABLE venda_cab ADD FOREIGN KEY(cod_funcionario) REFERENCES funcionario (cod_funcionario);
ALTER TABLE venda_cab ADD FOREIGN KEY(cod_cliente_j) REFERENCES cliente_juridico (cod_cliente_j);
ALTER TABLE venda_cab ADD FOREIGN KEY(cod_tipo_pgto) REFERENCES tipo_pagamento (cod_tipo_pgto);
ALTER TABLE venda_cab ADD FOREIGN KEY(cod_cliente_f) REFERENCES cliente_fisico (cod_cliente_f);
ALTER TABLE orcamento_cab ADD FOREIGN KEY(cod_funcionario) REFERENCES funcionario (cod_funcionario);
ALTER TABLE orcamento_det ADD FOREIGN KEY(cod_produto) REFERENCES produto (cod_produto);
ALTER TABLE nfe_cab_cfop ADD FOREIGN KEY(num_nfe_cab) REFERENCES nfe_cab (num_nfe_cab);
ALTER TABLE pagamento ADD FOREIGN KEY(cod_plano_conta) REFERENCES plano_conta (cod_plano_conta);
ALTER TABLE nfe_det ADD FOREIGN KEY(num_nfe_cab) REFERENCES nfe_cab (num_nfe_cab);
ALTER TABLE nfe_det ADD FOREIGN KEY(cod_produto) REFERENCES produto (cod_produto);
ALTER TABLE req_det ADD FOREIGN KEY(cod_req_cab) REFERENCES req_cab (cod_req_cab);

SELECT * FROM cliente_endereco;

SELECT * FROM visao_endereco WHERE cep = '78053025';

ALTER TABLE cliente_endereco DROP COLUMN pais;