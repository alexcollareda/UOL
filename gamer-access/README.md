Aplicação conta com os seguintes frameworks/tecnologias - EJB, CDI, JSF, JPA, Maven, Primefaces - Padrão EAR
Durante o desenvolvimento foi utilizado o servidor Weblogic 12.1.3, mas acredito que qualquer servidor container funcione normalmente.

1- Para executar deve ser criado um data source chamado: ds-uol    | com conexão ao banco de dados, independente do seu tipo (memoria, arquivo, etc).

2- Após criado o data source, deve ser implantado o pacote EAR localizado em gamer-access-ear/target/gamer-access-ear-0.0.1-SNAPSHOT.ear

3- Após implantado o site será disponibilizado na seguinte URL: http://localhost:7001/gamer-access-web/


*********************SCRIPT BANCO DE DADOS***************************

CREATE TABLE GAMER
(
ID_GAMER INTEGER PRIMARY KEY IDENTITY,
NOME VARCHAR(50) NOT NULL,
EMAIL VARCHAR(50) NOT NULL,
TELEFONE VARCHAR(20) NULL,
TEAM INTEGER NOT NULL,
CODINOME VARCHAR(20) NOT NULL
)
