// src/Pages/CadastroEmpresa/index.tsx
import React, { useState } from 'react';
import { FormContainer, FormLabel, FormInput, SubmitButton } from './styles'; // Estilize conforme necessário
import api from '../../services/api';
import { Empresa } from './types';

const CadastroEmpresa: React.FC = () => {
    const [empresa, setEmpresa] = useState<Empresa>({
        idEmpresa: 0, // Inicializa como zero, pois será gerado no backend
        nome: '',
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setEmpresa({ ...empresa, [name]: value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await api.post('/api/empresas', empresa);
            alert('Empresa cadastrada com sucesso!');
            setEmpresa({ idEmpresa: 0, nome: '' }); // Resetar o formulário
        } catch (error) {
            console.error('Erro ao cadastrar empresa:', error);
            alert('Erro ao cadastrar empresa. Verifique os dados.');
        }
    };

    return (
        <FormContainer>
            <h2>Cadastrar Empresa</h2>
            <form onSubmit={handleSubmit}>
                <FormLabel>
                    Nome:
                    <FormInput type="text" name="nome" value={empresa.nome} onChange={handleChange} required />
                </FormLabel>
                <SubmitButton type="submit">Cadastrar</SubmitButton>
            </form>
        </FormContainer>
    );
};

export default CadastroEmpresa;
