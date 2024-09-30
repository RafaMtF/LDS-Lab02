import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import CadastroCliente from './pages/CadastroCliente';
import VerCliente from './pages/Cliente';
import CadastroEmpresa from './pages/CadastroEmpresa';
import CadastroAutomovel from './pages/CadastroAutomovel';

const App: React.FC = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<CadastroCliente />} />
                <Route path="/clientes/:id" element={<VerCliente />} />
                <Route path="/cadastro-empresa" element={<CadastroEmpresa />} />]
                <Route path="/cadastro-automovel" element={<CadastroAutomovel />} />
            </Routes>
        </Router>
    );
};

export default App;
