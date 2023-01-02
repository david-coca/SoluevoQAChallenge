# language: pt
@Layer("web")
@Owner("Wellington")

Funcionalidade: Reportar Bug
Eu como usuário do sistema
Quero reportar um bug critico
Com o motivo da criticidade

Contexto: Acessar tela de login
  Dado que estou na tela do formulãrio

Cenário: Cadastro de Bug com sucesso
  E preencho todos os campos obrigatórios
  Quando anexar a evidencia
  E clicar em Submit
  Então vejo mensagem de usuário cadastrado com sucesso
