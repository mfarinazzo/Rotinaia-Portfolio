# Rotinaia: Assistente de Gestão Proativa com Inteligência Artificial

> **Status do Projeto:** Em desenvolvimento (MVP).
> **Nota:** Este repositório serve como demonstração do projeto. O código-fonte é mantido privado.

## Visão Geral

O **Rotinaia** é um projeto de assistente pessoal nativo para Android que explora o conceito de **Gestão Proativa**. Enquanto aplicativos tradicionais de agenda e finanças exigem que o usuário insira dados manualmente e gerencie conflitos de horário por conta própria, o Rotinaia utiliza Inteligência Artificial Generativa (Google Gemini) para assumir essa carga cognitiva.

A proposta é simples: o usuário fornece o contexto através de comandos de voz naturais, e o sistema estrutura, organiza e adapta a rotina e o fluxo financeiro automaticamente.

## O Problema e a Solução

Gerenciar o tempo e o dinheiro simultaneamente é uma tarefa complexa, especialmente para pessoas com rotinas dinâmicas que não podem parar para digitar em planilhas ou ajustar calendários a cada imprevisto.

O Rotinaia resolve isso através de uma interface **Voice-First** (focada na voz). Ao eliminar a fricção de menus e formulários, o aplicativo permite que o usuário mantenha sua organização em dia com apenas alguns segundos de interação falada.

**Diferenciais:**
*   **Adaptação Contextual:** O sistema entende a relação entre tarefas. Se um compromisso atrasa, ele sabe que isso impacta o restante do dia.
*   **Integração Financeira:** Despesas e ganhos são tratados como parte da rotina, permitindo uma visão holística de como o tempo investido se traduz em resultado financeiro.
*   **Interação Natural:** Não é necessário aprender comandos específicos. A LLM interpreta a intenção do usuário, mesmo em frases complexas ou informais.

## Demonstrações e Funcionalidades

Abaixo estão demonstrações das principais capacidades do sistema em sua versão atual.

### 1. Captura de Contexto por Voz
Nesta demonstração, o foco é a capacidade da IA de transformar linguagem natural não estruturada em dados estruturados (JSON) que o aplicativo pode utilizar.


https://github.com/user-attachments/assets/c96aaacc-89e9-4934-9cd7-9bb911b2e62a


<video src="1.mp4" controls="controls" style="max-width: 100%;">
  <a href="1.mp4">Assista ao vídeo 1</a>
</video>
<br>
*(Caso o vídeo não carregue, <a href="1.mp4">clique aqui para assistir</a>)*

> *Descrição do vídeo:* O usuário abre o aplicativo e toca no botão de microfone. Ele dita um comando complexo envolvendo tempo e dinheiro, por exemplo: "Agende uma reunião com o cliente para amanhã às 14h e lance uma despesa de 50 reais de Uber para chegar lá". O vídeo mostra o processamento e a criação imediata tanto do evento na agenda quanto da transação financeira.

### 2. Reagendamento Inteligente
Aqui demonstramos a proatividade do sistema. Ao invés de mover arrastar blocos de tempo manualmente, o usuário apenas informa o imprevisto.


https://github.com/user-attachments/assets/e54ad9d7-ff42-4c92-bd21-999d54e5e8e1


<video src="2.mp4" controls="controls" style="max-width: 100%;">
  <a href="2.mp4">Assista ao vídeo 2</a>
</video>
<br>
*(Caso o vídeo não carregue, <a href="2.mp4">clique aqui para assistir</a>)*

> *Descrição do vídeo:* A tela mostra uma lista de tarefas agendadas para a manhã. O usuário ativa o comando de voz e diz: "Tive um imprevisto e vou atrasar tudo em uma hora". O vídeo mostra a IA recalculando os horários de todas as tarefas subsequentes automaticamente, preservando a ordem e a duração.

### 3. Fluxo de Refinamento (Feedback Loop)
As IAs generativas podem cometer erros de interpretação. O Rotinaia implementa um fluxo de refinamento que permite ao usuário corrigir a IA de forma conversacional, sem descartar todo o trabalho feito.


https://github.com/user-attachments/assets/5e930e56-aa0c-4bfc-a03c-548045b1108f


<video src="3.mp4" controls="controls" style="max-width: 100%;">
  <a href="3.mp4">Assista ao vídeo 3</a>
</video>
<br>
*(Caso o vídeo não carregue, <a href="3.mp4">clique aqui para assistir</a>)*

> *Descrição do vídeo:* A IA apresenta uma proposta de agendamento que não está exatamente como o usuário queria (ex: marcou para o dia errado). O usuário clica em "Refinar" e diz apenas: "Não, isso é para sexta-feira, não para hoje". O vídeo mostra a IA ajustando apenas a data, mantendo os outros detalhes corretos.

### 4. Visão Geral e Funcionalidades Adicionais
Uma demonstração abrangente de outras capacidades do sistema que complementam a experiência de gestão proativa.


https://github.com/user-attachments/assets/bac5330f-ad50-4245-b783-5689232c1ca5


<video src="4.mp4" controls="controls" style="max-width: 100%;">
  <a href="4.mp4">Assista ao vídeo 4</a>
</video>
<br>
*(Caso o vídeo não carregue, <a href="4.mp4">clique aqui para assistir</a>)*

> *Descrição do vídeo:* Visão geral de funcionalidades auxiliares e navegação no aplicativo, demonstrando a fluidez da interface e outros recursos de produtividade.

## Arquitetura e Tecnologias

O projeto foi construído seguindo as melhores práticas de desenvolvimento Android moderno, garantindo escalabilidade e manutenibilidade.

*   **Linguagem:** Kotlin
*   **Interface de Usuário:** Jetpack Compose (Material Design 3)
*   **Inteligência Artificial:** Integração com Google Gemini 2.5 Flash via API REST.
*   **Arquitetura:** Clean Architecture com padrão MVVM (Model-View-ViewModel).
*   **Persistência de Dados:** Room Database (SQLite) para armazenamento local offline-first.
*   **Injeção de Dependência:** Hilt (Dagger).
*   **Concorrência:** Kotlin Coroutines e Flow para gerenciamento assíncrono de estados.

## Próximos Passos

O projeto continua em evolução, com foco atual em aprimorar a precisão do modelo de IA para contextos financeiros de longo prazo e na implementação de notificações inteligentes baseadas em geolocalização.

## Contato

Estou à disposição para discutir sobre a engenharia do projeto, os desafios de integração com LLMs em mobile e oportunidades de colaboração.

*   **LinkedIn:** https://www.linkedin.com/in/murilo-farinazzo-vieira-057301244/
*   **Email:** murilo.farinazzo@unesp.br
