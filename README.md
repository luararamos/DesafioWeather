Aplicativo climático que usa informações da geolocalização do usuário para definir qual a temperatura da cidade onde a pessoa está. Para isso, é utilizado o servidor Open Weather, através de uma requisição para conseguir a previsão do tempo. 

Desenvolvido em Java, a arquitetura utilizada é a MVVM. O build do projeto no celular ocorre o seguinte caminho: 

1-	A transição de telas do aplicativo (Splash), por meio do qual é feita a requisição de localização.

2-	 2- Usuário é direcionado para a Main, onde é apresentada a temperatura, a cidade e a descrição.

3-	 3- Se a permissão de localização falhar, o usuário fica na splash e não é direcionado para o Main (nesse caso, o usuário deve abrir a tela de configurações do celular e habilitar as permissões manualmente.

Os testes unitários verificam se as requisições e os dados utilizados da api estão ocorrendo corretamente. Por alguma razão, o teste apresentou falhas nos primeiros testes, requisitando talvez aperfeiçoamento do código.

Referências:
Open Weather API: https://openweathermap.org/
