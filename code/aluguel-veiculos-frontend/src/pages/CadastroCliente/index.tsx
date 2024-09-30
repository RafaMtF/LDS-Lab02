import React, { useState } from 'react';
import { FormContainer, FormLabel, FormInput, SubmitButton } from './styles';
import api from '../../services/api';
import { Cliente } from './types'; // Importando a interface

const CadastroCliente: React.FC = () => {
    const [cliente, setCliente] = useState<Cliente>({
        idCliente: 0,
        nome: '',
        rg: 0,
        cpf: 0,
        endereco: '',
        profissao: '',
        empregador: '',
        rendimentoUm: 0,
        rendimentoDois: 0,
        rendimentoTres: 0,
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setCliente({ ...cliente, [name]: value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const response = await api.post('/clientes', cliente);
            console.log("Cliente cadastrado com sucesso:", response.data);
        } catch (error) {
            console.error("Erro ao cadastrar cliente:", error);
        }
    };

    return (
        <FormContainer>
            <h2>Cadastro de Cliente</h2>
            <form onSubmit={handleSubmit}>
                <FormLabel>
                    Nome:
                    <FormInput type="text" name="nome" value={cliente.nome} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    RG:
                    <FormInput type="number" name="rg" value={cliente.rg} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    CPF:
                    <FormInput type="number" name="cpf" value={cliente.cpf} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Endereço:
                    <FormInput type="text" name="endereco" value={cliente.endereco} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Profissão:
                    <FormInput type="text" name="profissao" value={cliente.profissao} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Empregador:
                    <FormInput type="text" name="empregador" value={cliente.empregador} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Rendimento 1:
                    <FormInput type="number" step="0.01" name="rendimentoUm" value={cliente.rendimentoUm} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Rendimento 2:
                    <FormInput type="number" step="0.01" name="rendimentoDois" value={cliente.rendimentoDois} onChange={handleChange} />
                </FormLabel>
                <FormLabel>
                    Rendimento 3:
                    <FormInput type="number" step="0.01" name="rendimentoTres" value={cliente.rendimentoTres} onChange={handleChange} />
                </FormLabel>
                <SubmitButton type="submit">Cadastrar</SubmitButton>
            </form>
        </FormContainer>
    );
};

export default CadastroCliente;
