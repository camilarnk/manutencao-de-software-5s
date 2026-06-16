# exercicio 5 - Priorização da mudança

| Demanda                                                          | Valor de Negócio | Urgência | Risco | Esforço    | Prioridade |
| ---------------------------------------------------------------- | ---------------- | -------- | ----- | ---------- | ---------- |
| Corrigir envio duplicado de lembretes de consulta                | Alto             | Alta     | Alto  | Médio      | 1          |
| Implementar lista de espera automática para consultas canceladas | Alto             | Média    | Médio | Médio/Alto | 2          |
| Corrigir lentidão na busca de pacientes pelo nome                | Médio            | Média    | Médio | Alto       | 3          |
| Melhorar exportação de relatórios financeiros em PDF             | Médio            | Baixa    | Baixo | Médio      | 4          |

## justificativa da ordem definida

A correção do envio duplicado de lembretes recebeu prioridade máxima por impactar diretamente a comunicação com os pacientes, podendo gerar reclamações, confusão e perda de credibilidade da clínica.

A implementação da lista de espera automática foi definida como segunda prioridade por agregar valor significativo ao negócio, reduzindo horários ociosos e melhorando o aproveitamento da agenda médica.

A correção da lentidão na busca de pacientes foi considerada importante para a produtividade dos funcionários, porém não afeta diretamente os pacientes de forma imediata.

A melhoria da exportação de relatórios financeiros em PDF foi considerada a demanda menos urgente, pois trata-se principalmente de uma melhoria de usabilidade sem impacto crítico na operação diária da clínica.

# exercicio 6 - controle da mudança

Registro Consolidado da Mudança

ID: ID0001

Título: Mover pessoa da lista de espera para consulta atual

Descrição Refinada:
Quando uma consulta for cancelada por um paciente ou por um funcionário autorizado da clínica, o sistema deverá identificar automaticamente o primeiro paciente elegível na lista de espera correspondente e oferecer a vaga disponível. Caso o paciente aceite a oferta dentro do prazo definido pela clínica, a consulta será reagendada automaticamente para o horário liberado. Todas as movimentações deverão ser registradas para fins de auditoria e histórico.

Prioridade: Alta (2ª prioridade geral do backlog)

Status: Em análise técnica

Dependências:

Existência de lista de espera cadastrada para a especialidade ou profissional.
Integração com o módulo de notificações.
Regras de cancelamento já implementadas no sistema.
Cadastro atualizado dos pacientes.

Módulos Afetados:

Agenda de Consultas.
Cadastro de Pacientes.
Notificações (SMS e E-mail).
Banco de Dados.
Relatórios Administrativos (histórico de movimentações).

Responsáveis:

Função	Responsabilidade
Analista de Requisitos	Refinamento das regras de negócio
Desenvolvedor Backend	Implementação das regras da lista de espera
Desenvolvedor Frontend	Ajustes nas telas de agendamento e fila
Analista de Testes (QA)	Criação e execução dos testes
Gestor de Projeto	Aprovação e acompanhamento da mudança

Versão Prevista: Versão 2.1.0

Observações Relevantes:

O sistema deve respeitar a ordem cronológica da lista de espera.
Apenas pacientes compatíveis com a especialidade da consulta poderão receber a vaga.
O histórico de cancelamentos e realocações deve ser armazenado.
Caso não existam pacientes na lista de espera, o horário permanecerá disponível para agendamento comum.
A implementação não deve impactar negativamente o desempenho do módulo de agenda.
As notificações geradas pela mudança devem seguir as mesmas regras definidas para o módulo de comunicação da clínica.

# exercicio 10 – Reflexão Final
1. Qual foi a parte mais difícil do ciclo de gestão de mudança?

A etapa mais difícil foi a análise de impacto, pois a solicitação inicial parecia simples, mas afeta diversos módulos do sistema. Foi necessário identificar dependências entre agenda, cadastro de pacientes, notificações e banco de dados para compreender completamente as consequências da mudança.

2. Em qual etapa o risco técnico ficou mais evidente?

O risco técnico ficou mais evidente durante a identificação de riscos e a análise de impacto. Nessas etapas foi possível perceber que falhas na lógica da fila de espera ou no envio das notificações poderiam causar inconsistências nos agendamentos e problemas de comunicação com os pacientes.

3. O que poderia dar errado se a equipe pulasse a análise de impacto?

Sem a análise de impacto, a equipe poderia modificar apenas o módulo de agenda e esquecer integrações importantes, como notificações e registros históricos. Isso poderia gerar falhas de funcionamento, perda de dados, comportamento inconsistente do sistema e aumento dos custos de manutenção futura.

4. O que poderia dar errado se a mudança não fosse rastreada adequadamente?

A ausência de rastreabilidade dificultaria identificar quais requisitos foram implementados, quais componentes foram alterados e quais testes deveriam ser executados. Isso aumentaria o risco de erros em futuras manutenções e tornaria mais difícil corrigir problemas ou auditar alterações realizadas no sistema.

5. Por que gestão de mudança não deve ser confundida apenas com implementação?

A implementação representa apenas uma parte do processo. A gestão de mudança envolve planejamento, análise de impacto, avaliação de riscos, priorização, controle, rastreabilidade e validação. Essas atividades garantem que a alteração seja realizada de forma segura, organizada e alinhada às necessidades do negócio, reduzindo a probabilidade de falhas e retrabalho.
