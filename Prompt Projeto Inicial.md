 Prompt Projeto Inicial 

 Para iniciar o projeto, você precisará criar um novo projeto Angular com o Angular CLI. Você pode fazer isso usando o seguinte comando:

```
ng new sistema-sugestoes
```

Este comando criará um novo diretório chamado "sistema-sugestoes" com um projeto Angular básico.

Em seguida, você precisará criar um novo projeto Spring Boot com o Spring Initializr. Você pode fazer isso usando o seguinte site:

[https://start.spring.io/](https://start.spring.io/)

Selecione as seguintes dependências:

* Web
* JPA
* H2

Clique em "Generate" para gerar o projeto.

Depois que os projetos estiverem criados, você precisará configurar a comunicação entre o front-end e o back-end.

No back-end, você precisará criar uma API REST para gerenciar as sugestões. Você pode usar o seguinte código como ponto de partida:

```
@RestController
@RequestMapping("/sugestoes")
public class SugestaoController {

    @Autowired
    private SugestaoRepository repository;

    @PostMapping
    public Sugestao salvar(@RequestBody Sugestao sugestao) {
        return repository.save(sugestao);
    }

    @GetMapping
    public List<Sugestao> listar() {
        return repository.findAll();
    }

}
```

Esta API fornece dois endpoints:

* `/sugestoes` - Este endpoint salva uma nova sugestão.
* `/sugestoes` - Este endpoint lista todas as sugestões.

No front-end, você precisará usar o Angular HTTP Client para fazer chamadas para a API REST. Você pode usar o seguinte código como ponto de partida:

```
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'app-sugestoes',
    templateUrl: './sugestoes.component.html',
    styleUrls: ['./sugestoes.component.css']
})
export class SugestoesComponent implements OnInit {

    suggestions: Sugestao[] = [];

    constructor(private http: HttpClient) {}

    ngOnInit() {
        this.getSugestoes();
    }

    getSugestoes() {
        this.http.get('/sugestoes').subscribe((data: Sugestao[]) => {
            this.suggestions = data;
        });
    }

}
```

Este código usa o Angular HTTP Client para chamar o endpoint `/sugestoes` da API REST. Quando a resposta for recebida, ela será armazenada na propriedade `suggestions` do componente.

Para criar a interface do usuário, você precisará usar HTML, CSS e Angular. Você pode usar o seguinte código como ponto de partida:


<h1>Sistema de Sugestões</h1>

<div class="container">

    <div class="row">
        <div class="col-md-6">
            <h2>Sugestões Pendentes</h2>
            <ul class="list-group">
                <li class="list-group-item" *ngFor="let sugestao of suggestions | filter: { status: 'pendente' }">
                    {{ sugestao.descricao }}
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <h2>Sugestões em Análise</h2>
            <ul class="list-group">
                <li class="list-group-item" *ngFor="let sugestao of suggestions | filter: { status: 'analise' }">
                    {{ sugestao.descricao }}
                </li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h2>Sugestões Aprovadas</h2>
            <ul class="list-group">
                <li class="list-group-item" *ngFor="let sugestao of suggestions | filter: { status: 'aprovada' }">
                    {{ sugestao.descricao }}
                </li>
            </ul>
        </div>
    </div>

</div>