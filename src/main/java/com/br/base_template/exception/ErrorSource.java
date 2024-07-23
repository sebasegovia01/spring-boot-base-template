package com.br.base_template.exception;

public enum ErrorSource {
    OTP, // BACKEND ONE TIME PASSWORD
    SIN, // Sistema Core Externo para validación de identidad de clientes
    SINACOFI, // SINACOFI
    CMA, // BACKEND CLAVE MAESTRA/COORDENADAS
    RLZ, // BACKEND MOTOR DE REGLAS
    TEF, // Sistema Core para transferencias electrónicas de fondos
    BEN, // BACKEND TEF BENEFICIARIO
    BOP, // Sistema Core con información de clientes
    BOPERS, // BOPERS
    SEG, // Sistema Core con información de seguros
    FIDENS, // FIDENS
    FRW, // FRAMEWORK - Normalmente excepciones técnicas
    FIS, // Sistema Core con información de cuentas
    FISA, // FISA
    SAT, // Sistema Core con información de tarjetas
    RSAT, // RSAT
    CAM, // Sistema Core de gestión de campañas
    ADM, // Sistema Core de plataforma comercial
    MTR, // Sistema Core para gestión de riesgo
    PRE, // Sistema Core Externo con información previsional de clientes
    PREVIRED, // PREVIRED
    CLU, // Sistema Core de gestión de credenciales de los clientes
    DOW, // DOCUWARE
    RIR, // Sistema Core de Ripley Retail
    UNK, // Sistema UNIKEE
    PTF, // Portabilidad Financiera
    CDY, // Card Dynamics
    API, // API Connect
    EPU, // Backend de Estado de Pago Único (EPU) de la Tarjeta Ripley (PDF del Estado de cuenta)
    CHK, // backend de Aplicación Chek
    AUT // Autenticación Digital
}