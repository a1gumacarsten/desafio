<!DOCTYPE html>
<html>
<head>
  <h4>API de Fornecedores - Documentação dos Endpoints</h4>

   <h2>Acessando a Interface HTML</h2>
  <p>A interface HTML está localizada na pasta "static" do projeto. Você pode acessá-la através da seguinte URL:</p>
  <code>http://localhost:8080/index.html</code>
  <p>Certifique-se de que o servidor esteja em execução para acessar a interface.</p>
</head>
<body>
  <h1>API de Fornecedores - Documentação dos Endpoints</h1>

  <h2>POST /supplier/create</h2>
  <p>Cria um novo fornecedor.</p>

<h3>Payload Exemplo:</h3>
<pre>
<code>
{
  "name": "Fornecedor Atualizado",
  "email": "atualizado@teste.com",
  "telephones": [
    {
      "numero": "987654321"
    }
  ],
  "type": "DISTRIBUIDOR",
  "observation": "Observação atualizada do fornecedor",
  "favorite": true
}
</code>
</pre>


  <h2>PUT /supplier/update/{id}</h2>
  <p>Atualiza os detalhes de um fornecedor existente.</p>

  <h3>Payload Exemplo:</h3>
<pre>
<code>
{
  "name": "Fornecedor Atualizado",
  "email": "atualizado@teste.com",
  "telephones": [
    {
      "numero": "987654321"
    }
  ],
  "type": "DISTRIBUIDOR",
  "observation": "Observação atualizada do fornecedor",
  "id": 1
}
</code>
</pre>

  <h2>GET /supplier</h2>
  <p>Obtém a lista de todos os fornecedores.</p>

  <h2>DELETE /supplier/delete</h2>
  <p>Remove um ou mais fornecedores.</p>
  
  <h3>Parâmetros:</h3>
  <ul>
    <li>ids (array de Longs): Lista de IDs dos fornecedores a serem removidos.</li>
  </ul>

  <h2>POST /supplier/favorite/{id}</h2>
  <p>Marca ou desmarca um fornecedor como favorito.</p>
</body>
</html>
