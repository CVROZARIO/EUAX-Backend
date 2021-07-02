Esta aplicação foi desenvolvida com Intellij IDEA. Não é necessária instalação de nenhuma third party.

A aplicação incorpora o HSQLDB (http://hsqldb.org/) para BBDD em memória. O HSQLDB está configurado para limpar o base a cada compilação do projeto, vide arquivo application.properties.
Após executar a aplicação, em modo debug ou não, navegue até http://localhost:8080/, nesse serão listados todos os endpoints, conforme:

    /project/create
    [POST] Cadastro de Projeto
    
    /project/delete
    [POST] Deleção de Projeto
    
    /project/status
    [GET] Lista de Projetos Cadastrados e seus Status
    
    /project/list
    [GET] Lista de Projetos Cadastrados
    
    /project/activity/create
    [POST] Cadastro de Atividade de Projeto
    
    /project/activity/delete
    [POST] Deleção de Atividade de Projeto
    
    /project/activity/list
    [GET] Lista de Atividades de Projetos Cadastrados
    

Divirta-se =)
