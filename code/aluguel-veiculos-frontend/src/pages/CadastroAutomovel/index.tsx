// src/Pages/CadastroAutomovel/index.tsx
import React, { useState } from 'react';
import { FormContainer, FormLabel, FormInput, SubmitButton } from './styles'; // Estilize conforme necessário
import api from '../../services/api';
import { Automovel } from './types';

const CadastroAutomovel: React.FC = () => {
    const [automovel, setAutomovel] = useState<Automovel>({
        idAutomovel: 0, // Inicializa como zero, será gerado no backend
        matricula: '',
        ano: new Date().getFullYear(), // Você pode definir um ano padrão, se desejar
        marca: '',
        modelo: '',
        placa: '',
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setAutomovel({ ...automovel, [name]: value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await api.post('/automoveis', automovel);
            alert('Automóvel cadastrado com sucesso!');
            setAutomovel({ idAutomovel: 0, matricula: '', ano: new Date().getFullYear(), marca: '', modelo: '', placa: '' }); // Resetar o formulário
        } catch (error) {
            console.error('Erro ao cadastrar automóvel:', error);
            alert('Erro ao cadastrar automóvel. Verifique os dados.');
        }
    };

    return (
        <FormContainer>
            <h2>Cadastrar Automóvel</h2>
            <form onSubmit={handleSubmit}>
                <FormLabel>
                    Matrícula:
                    <FormInput type="text" name="matricula" value={automovel.matricula} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Ano:
                    <FormInput type="number" name="ano" value={automovel.ano} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Marca:
                    <FormInput type="text" name="marca" value={automovel.marca} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Modelo:
                    <FormInput type="text" name="modelo" value={automovel.modelo} onChange={handleChange} required />
                </FormLabel>
                <FormLabel>
                    Placa:
                    <FormInput type="text" name="placa" value={automovel.placa} onChange={handleChange} required />
                </FormLabel>
                <SubmitButton type="submit">Cadastrar</SubmitButton>
            </form>
        </FormContainer>
    );
};

export default CadastroAutomovel;
