export interface Cliente {
    idCliente: number;
    nome: string;
    rg: number;
    cpf: number;
    endereco: string;
    profissao: string;
    empregador: string;
    rendimentoUm: number;
    rendimentoDois?: number;
    rendimentoTres?: number; 
}