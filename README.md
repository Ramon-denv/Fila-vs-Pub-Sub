# Fila-vs-Pub-Sub

 ## Fila de Mensagens:
 As mensagens são enviadas para uma fila, e cada mensagem é processada por um
 único consumidor.
 Utilizando uma Direct Exchange com uma chave de roteamento específica
 (sorveteria). As mensagens enviadas para essa exchange são entregues a uma fila
 específica sorveteriaQueue.
 Oconsumidor (Sorveteria) escuta essa fila e processa os pedidos de sorvete um por
 um. Cada pedido de sorvete é processado individualmente, e o cliente recebe uma
 confirmação assim que o pedido estiver pronto.
 Quando o cliente (ClienteProdutor) faz um pedido de sorvete, o pedido é colocado
 na fila, e o consumidor (Sorveteria) processa o pedido em tempo real, preparando o
 sorvete e informando o cliente sobre o status do pedido.
 ## Pub/Sub:
 Umamensagem é enviada para todos os consumidores inscritos em uma exchange.
 Todos os clientes (consumidores) que se inscreveram para ouvir as mensagens de
 um determinado canal recebem as mesmas mensagens.
 Utilizando uma Fanout Exchange, onde as mensagens enviadas para essa
 exchange são distribuídas para todas as filas conectadas a ela, sem se preocupar
 com uma chave de roteamento.
 Tanto o PrimeiroCliente quanto o SegundoCliente estão inscritos para receber
 notificações sobre novos sabores de sorvete, e ambos recebem a mesma
 mensagem.
 Quando o produtor (SorveteriaProdutor) anuncia um novo sabor, todos os clientes
 inscritos (PrimeiroCliente e SegundoCliente) são notificados simultaneamente.
