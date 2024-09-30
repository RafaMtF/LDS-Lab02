// src/Pages/VerCliente/index.tsx
import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { FormContainer, FormLabel, FormInput, SubmitButton, DeleteButton } from './styles';
import api from '../../services/api';
import { Cliente } from '../CadastroCliente/types'; // Importando o tipo Cliente

const VerCliente: React.FC = () => {
    const { id } = useParams<{ id: string }>(); // Pega o ID do cliente da URL
    const [cliente, setCliente] = useState<Cliente | null>(null);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchCliente = async () => {
            try {
                const response = await api.get(`/clientes/${id}`);
                setCliente(response.data);
            } catch (error) {
                console.error("Erro ao buscar cliente:", error);
            }
        };

        fetchCliente();
    }, [id]);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        if (cliente) {
            setCliente({ ...cliente, [name]: value });
        }
    };

    const handleUpdate = async (e: React.FormEvent) => {
        e.preventDefault();
        if (cliente) {
            try {
                await api.put(`/clientes/${cliente.idCliente}`, cliente);
                alert("Cliente atualizado com sucesso!");
            } catch (error) {
                console.error("Erro ao atualizar cliente:", error);
            }
        }
    };

    const handleDelete = async () => {
        if (cliente) {
            try {
                await api.delete(`/clientes/${cliente.idCliente}`);
                alert("Cliente excluído com sucesso!");
                navigate('/'); // Redireciona para a página inicial ou onde preferir
            } catch (error) {
                console.error("Erro ao excluir cliente:", error);
            }
        }
    };

    if (!cliente) {
        return <div>Carregando...</div>; // Exibe uma mensagem enquanto os dados estão sendo carregados
    }

    return (
        <FormContainer>
            <h2>Visualizar Cliente</h2>
            <form onSubmit={handleUpdate}>
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
                <SubmitButton type="submit">Atualizar</SubmitButton>
            </form>
            <DeleteButton onClick={handleDelete}>Excluir Cliente</DeleteButton>
        </FormContainer>
    );
};

export default VerCliente;
