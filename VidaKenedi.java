import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

// Classe base para representar uma pessoa
abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected String profissao;
    protected List<String> caracteristicas;
    protected LocalDate dataNascimento;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.caracteristicas = new ArrayList<>();
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = calcularIdade();
        this.caracteristicas = new ArrayList<>();
    }

    private int calcularIdade() {
        if (dataNascimento != null) {
            return Period.between(dataNascimento, LocalDate.now()).getYears();
        }
        return 0;
    }

    public abstract void apresentar();
    
    public String getNome() { return nome; }
    public int getIdade() { 
        if (dataNascimento != null) {
            this.idade = calcularIdade();
        }
        return idade; 
    }
    public void setIdade(int idade) { this.idade = idade; }
    
    public void adicionarCaracteristica(String caracteristica) {
        if (!caracteristicas.contains(caracteristica)) {
            caracteristicas.add(caracteristica);
        }
    }
    
    public void removerCaracteristica(String caracteristica) {
        caracteristicas.remove(caracteristica);
    }
}

// Classe para os pais
class Pai extends Pessoa {
    public Pai() {
        super("Roberto", 43);
        this.profissao = "Pintor Autônomo";
        caracteristicas.add("Produtivo");
        caracteristicas.add("Detalhista");
        caracteristicas.add("Capricho");
        caracteristicas.add("Dedicação");
    }

    @Override
    public void apresentar() {
        System.out.println("Pai: " + nome + " (" + idade + " anos)");
        System.out.println("Profissão: " + profissao);
        System.out.println("Características: " + String.join(", ", caracteristicas));
    }
}

class Mae extends Pessoa {
    public Mae() {
        super("Adriane", 42);
        this.profissao = "Empresária";
        caracteristicas.add("Empreendedora");
        caracteristicas.add("Comunicativa");
        caracteristicas.add("Trabalhadora");
        caracteristicas.add("Visionária");
    }

    @Override
    public void apresentar() {
        System.out.println("Mãe: " + nome + " (" + idade + " anos)");
        System.out.println("Profissão: " + profissao);
        System.out.println("Características: " + String.join(", ", caracteristicas));
    }
}

// Classe principal para Kenedi com fases da vida
class Kenedi extends Pessoa {
    private List<String> virtudes;
    private List<String> vicios;
    private List<String> talentos;
    private List<String> gosta;
    private List<String> naoGosta;
    private String sonho;
    private boolean feliz;
    private List<String> historicoVida;
    private String faseAtual;

    public Kenedi() {
        super("Kenedi", LocalDate.of(2002, 6, 12));
        this.virtudes = new ArrayList<>();
        this.vicios = new ArrayList<>();
        this.talentos = new ArrayList<>();
        this.gosta = new ArrayList<>();
        this.naoGosta = new ArrayList<>();
        this.historicoVida = new ArrayList<>();
        
        inicializarCaracteristicasBasicas();
        this.sonho = "Viajar pelo mundo e conhecer culturas";
        this.feliz = true;
        this.faseAtual = "Jovem Adulto";
    }

    private void inicializarCaracteristicasBasicas() {
        // Características pessoais
        virtudes.add("Honestidade");
        virtudes.add("Prudência");
        virtudes.add("Mansidão");
        
        vicios.add("Preguiça");
        vicios.add("Procrastinação");
        
        talentos.add("Design UX/UI");
        talentos.add("Atendimento e comunicação");
        
        gosta.add("Jogar");
        gosta.add("Praticar atividade física");
        gosta.add("Namar");
        
        naoGosta.add("Mandar áudio");
        naoGosta.add("Falar sobre mim");
        naoGosta.add("Me expor");
        naoGosta.add("Falar em público");
        naoGosta.add("Apresentar trabalhos");
        
        this.sonho = "Viajar pelo mundo e conhecer culturas";
        this.feliz = true;
    }

    // Métodos dinâmicos para modificar características
    public void adicionarVirtude(String virtude) {
        if (!virtudes.contains(virtude)) {
            virtudes.add(virtude);
            System.out.println("[OK] Virtude '" + virtude + "' adicionada!");
        }
    }
    
    public void adicionarVicio(String vicio) {
        if (!vicios.contains(vicio)) {
            vicios.add(vicio);
            System.out.println("[!] Vicio '" + vicio + "' adicionado!");
        }
    }
    
    public void adicionarTalento(String talento) {
        if (!talentos.contains(talento)) {
            talentos.add(talento);
            System.out.println("[*] Talento '" + talento + "' adicionado!");
        }
    }
    
    public void definirSonho(String novoSonho) {
        this.sonho = novoSonho;
        System.out.println("[GOAL] Novo sonho definido: " + sonho);
    }
    
    public void mudarFelicidade(boolean estado) {
        this.feliz = estado;
        System.out.println("[MOOD] Estado de felicidade alterado para: " + (feliz ? "Feliz" : "Triste"));
    }
    
    public void adicionarEventoVida(String evento) {
        historicoVida.add(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ": " + evento);
        System.out.println("[EVENT] Evento adicionado ao historico!");
    }

    @Override
    public void apresentar() {
        System.out.println("\n[USER] === QUEM SOU EU ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Idade Atual: " + getIdade() + " anos");
        System.out.println("Fase Atual: " + faseAtual);
        System.out.println("Descricao: Jovem adulto no 6 semestre de SI na AMF e desenvolvendo o negocio da familia");
        System.out.println("Virtudes: " + String.join(", ", virtudes));
        System.out.println("Vicios: " + String.join(", ", vicios));
        System.out.println("Talentos: " + String.join(", ", talentos));
        System.out.println("Gosta de: " + String.join(", ", gosta));
        System.out.println("Nao gosta de: " + String.join(", ", naoGosta));
        System.out.println("Principal sonho: " + sonho);
        System.out.println("E feliz? " + (feliz ? "Sim" : "Nao"));
    }
    
    public void mostrarHistorico() {
        System.out.println("\n[HIST] === HISTORICO DE VIDA ===");
        if (historicoVida.isEmpty()) {
            System.out.println("Nenhum evento registrado ainda.");
        } else {
            for (String evento : historicoVida) {
                System.out.println("* " + evento);
            }
        }
    }

    // Método para simular fases da vida
    public void viverFase(String faixa, String eventos) {
        System.out.println("\n[LIFE] === FASE: " + faixa + " ===");
        System.out.println(eventos);
        this.faseAtual = faixa;
    }
    
    // Getters para acesso às listas (para interação dinâmica)
    public List<String> getVirtudes() { return new ArrayList<>(virtudes); }
    public List<String> getVicios() { return new ArrayList<>(vicios); }
    public List<String> getTalentos() { return new ArrayList<>(talentos); }
    public String getSonho() { return sonho; }
    public boolean isFeliz() { return feliz; }
}

// Classe para o Projeto de Natureza (Negócio Familiar)
class ProjetoNatureza {
    private String tipo;
    private String descricao;
    private String papel;
    private boolean ativo;
    private List<String> objetivos;
    private int progresso; // 0-100%

    public ProjetoNatureza() {
        this.tipo = "Negócio Familiar";
        this.descricao = "Empresa familiar em desenvolvimento";
        this.papel = "Sócio-desenvolvedor responsável por tecnologia e crescimento";
        this.ativo = true;
        this.objetivos = new ArrayList<>();
        this.progresso = 65; // Progresso atual
        
        // Objetivos iniciais
        objetivos.add("Consolidar marca no mercado local");
        objetivos.add("Implementar sistema de vendas online");
        objetivos.add("Expandir para outras cidades");
    }

    public void executarProjeto() {
        System.out.println("\n[PROJ] === PROJETO DE NATUREZA ===");
        System.out.println("Tipo: " + tipo);
        System.out.println("Descricao: " + descricao);
        System.out.println("Meu papel: " + papel);
        System.out.println("Status: " + (ativo ? "Em desenvolvimento ativo" : "Inativo"));
        System.out.println("Progresso: " + progresso + "%");
        System.out.println("Objetivos:");
        for (int i = 0; i < objetivos.size(); i++) {
            System.out.println("   " + (i + 1) + ". " + objetivos.get(i));
        }
        System.out.println("Objetivo futuro: Profissional de TI trabalhando remotamente para o exterior e consolidacao da empresa familiar");
    }
    
    public void adicionarObjetivo(String objetivo) {
        objetivos.add(objetivo);
        System.out.println("[OK] Objetivo adicionado: " + objetivo);
    }
    
    public void atualizarProgresso(int novoProgresso) {
        if (novoProgresso >= 0 && novoProgresso <= 100) {
            this.progresso = novoProgresso;
            System.out.println("[UPD] Progresso atualizado para: " + progresso + "%");
        }
    }
}

// Classe para sistema de menu interativo
class SistemaInterativo {
    private Scanner scanner;
    private Kenedi kenedi;
    private ProjetoNatureza projeto;
    private Pai pai;
    private Mae mae;

    public SistemaInterativo() {
        this.scanner = new Scanner(System.in);
        this.kenedi = new Kenedi();
        this.projeto = new ProjetoNatureza();
        this.pai = new Pai();
        this.mae = new Mae();
    }

    public void iniciar() {
        System.out.println("[*] === SISTEMA INTERATIVO DA VIDA ===");
        System.out.println("Bem-vindo ao sistema dinamico de vida do Kenedi!");
        
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    kenedi.apresentar();
                    break;
                case 2:
                    mostrarFamilia();
                    break;
                case 3:
                    projeto.executarProjeto();
                    break;
                case 4:
                    adicionarCaracteristica();
                    break;
                case 5:
                    gerenciarSonhos();
                    break;
                case 6:
                    adicionarEvento();
                    break;
                case 7:
                    kenedi.mostrarHistorico();
                    break;
                case 8:
                    mostrarFasesVida();
                    break;
                case 9:
                    atualizarProjeto();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("[!] Sistema encerrado. Ate logo!");
                    break;
                default:
                    System.out.println("[!] Opcao invalida!");
            }
            
            if (continuar) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
                limparTela();
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n[MENU] === MENU PRINCIPAL ===");
        System.out.println("1. [USER] Ver perfil completo");
        System.out.println("2. [FAM] Ver familia");
        System.out.println("3. [PROJ] Ver projeto de natureza");
        System.out.println("4. [+] Adicionar caracteristica");
        System.out.println("5. [GOAL] Gerenciar sonhos");
        System.out.println("6. [EVENT] Adicionar evento a vida");
        System.out.println("7. [HIST] Ver historico de vida");
        System.out.println("8. [LIFE] Ver fases da vida");
        System.out.println("9. [UPD] Atualizar projeto");
        System.out.println("0. [EXIT] Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private int lerOpcao() {
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            return opcao;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void mostrarFamilia() {
        System.out.println("\n[FAM] === FAMILIA ===");
        pai.apresentar();
        System.out.println();
        mae.apresentar();
        System.out.println("\nDecada que se conheceram: 2000");
    }

    private void adicionarCaracteristica() {
        System.out.println("\n[+] === ADICIONAR CARACTERISTICA ===");
        System.out.println("1. Virtude");
        System.out.println("2. Vicio");
        System.out.println("3. Talento");
        System.out.print("Escolha o tipo: ");
        
        int tipo = lerOpcao();
        System.out.print("Digite a característica: ");
        String caracteristica = scanner.nextLine();
        
        switch (tipo) {
            case 1:
                kenedi.adicionarVirtude(caracteristica);
                break;
            case 2:
                kenedi.adicionarVicio(caracteristica);
                break;
            case 3:
                kenedi.adicionarTalento(caracteristica);
                break;
                default:
                    System.out.println("[!] Tipo invalido!");
            }
        }

        private void gerenciarSonhos() {
            System.out.println("\n[GOAL] === GERENCIAR SONHOS ===");
            System.out.println("Sonho atual: " + kenedi.getSonho());
            System.out.print("Deseja alterar? (s/n): ");

            if (scanner.nextLine().toLowerCase().startsWith("s")) {
                System.out.print("Digite o novo sonho: ");
                String novoSonho = scanner.nextLine();
                kenedi.definirSonho(novoSonho);
            }
        }

        private void adicionarEvento() {
            System.out.println("\n[EVENT] === ADICIONAR EVENTO ===");
            System.out.print("Descreva o evento: ");
            String evento = scanner.nextLine();
            kenedi.adicionarEventoVida(evento);
        }
        
        private void mostrarFasesVida() {
            System.out.println("\n[LIFE] === FASES DA VIDA ===");
        
        kenedi.viverFase("0 a 5 anos", 
            "* Primeiros passos aos 8 meses\n" +
            "* Comecei a falar com 2 anos\n" +
            "* Morava no Uruguai e aos 3 anos vim para o Brasil\n" +
            "* Primeira memória: no carro com os pais vindo da fronteira (Uruguai) para Agudo-RS");

        kenedi.viverFase("5 a 7 anos",
            "* Formei amizades que tenho até hoje\n" +
            "* Aprendi a ler aos 5 quase 6 anos de idade");

        kenedi.viverFase("8 a 10 anos",
            "* Trinquei o braço brincando na escola (gesso por 1 mês)\n" +
            "* Brincava de pega-pega, esconde-esconde, bolinha de gude\n" +
            "* Queria ser Engenheiro Civil");

        kenedi.viverFase("10 a 12 anos",
            "* Primeiro computador e contato com a tecnologia");

        kenedi.viverFase("13 a 15 anos",
            "* Jogava CS:GO, GTA SA, Rocket League, Minecraft");

        kenedi.viverFase("16 a 18 anos",
            "* Era estagiário CIEE (R$ 500/mês)\n" +
            "* Comprei bicicleta, celular e juntei para CNH\n" +
            "* Me formei no ensino médio durante a pandemia");

        kenedi.viverFase("19 a 23 anos (atual)",
            "* Entrei no Exército Brasileiro (3 anos de serviço)\n" +
            "* Moro sozinho com a namorada\n" +
            "* Cursando SI na AMF (6º semestre)\n" +
            "* Ajudei a abrir negócio familiar");
    }

        private void atualizarProjeto() {
            System.out.println("\n[UPD] === ATUALIZAR PROJETO ===");
            System.out.println("1. Atualizar progresso");
            System.out.println("2. Adicionar objetivo");
            System.out.print("Escolha uma opcao: ");        int opcao = lerOpcao();
        
        switch (opcao) {
            case 1:
                System.out.print("Digite o novo progresso (0-100): ");
                int progresso = lerOpcao();
                projeto.atualizarProgresso(progresso);
                break;
            case 2:
                System.out.print("Digite o novo objetivo: ");
                String objetivo = scanner.nextLine();
                projeto.adicionarObjetivo(objetivo);
                break;
                default:
                    System.out.println("[!] Opcao invalida!");
                }
            }

            private void limparTela() {
                // Simula limpeza de tela
                System.out.println("\n".repeat(2));
            }
        }// Classe principal para execução - Sistema Interativo
public class VidaKenedi {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("    SISTEMA DINAMICO DE VIDA - KENEDI");
        System.out.println("==========================================");
        System.out.println(">> Escolha entre modo automatico ou interativo\n");

        Scanner scanner = new Scanner(System.in);
        System.out.println(">> Escolha o modo de execucao:");
        System.out.println("1. [*] Modo Interativo (Recomendado)");
        System.out.println("2. [>] Modo Automatico (Demonstracao completa)");
        System.out.print("Digite sua escolha (1 ou 2): ");

        try {
            int escolha = Integer.parseInt(scanner.nextLine());
            
            switch (escolha) {
                case 1:
                    // Modo interativo
                    SistemaInterativo sistema = new SistemaInterativo();
                    sistema.iniciar();
                    break;
                    
                case 2:
                    // Modo automático (código original melhorado)
                    executarModoAutomatico();
                    break;
                    
                default:
                    System.out.println("[!] Opcao invalida! Executando modo automatico...");
                    executarModoAutomatico();
            }
        } catch (NumberFormatException e) {
            System.out.println("[!] Entrada invalida! Executando modo automatico...");
            executarModoAutomatico();
        }
        
        scanner.close();
    }

    private static void executarModoAutomatico() {
        System.out.println("\n[>] === MODO AUTOMATICO - DEMONSTRACAO COMPLETA ===\n");

        // Criação dos objetos (nascimento)
        Pai pai = new Pai();
        Mae mae = new Mae();
        Kenedi kenedi = new Kenedi();
        ProjetoNatureza projeto = new ProjetoNatureza();

        // Apresentação da família
        System.out.println("[FAMILIA] === CONTEXTO FAMILIAR ===");
        pai.apresentar();
        System.out.println();
        mae.apresentar();
        System.out.println("[+] Decada que se conheceram: 2000");

        // Apresentação pessoal
        kenedi.apresentar();

        // Demonstração de funcionalidades dinâmicas
        System.out.println("\n[~] === DEMONSTRACAO DE FUNCIONALIDADES DINAMICAS ===");
        
        // Adicionando características dinamicamente
        kenedi.adicionarVirtude("Persistência");
        kenedi.adicionarTalento("Programação");
        kenedi.adicionarEventoVida("Apresentação do sistema dinâmico na faculdade");
        
        // Atualizando sonho
        kenedi.definirSonho("Ser um desenvolvedor reconhecido internacionalmente");

        // Ciclo de vida - Transformações ao longo do tempo
        System.out.println("\n==========================================");
        System.out.println("        [FASES] CICLO DE VIDA - FASES");
        System.out.println("==========================================");

        kenedi.viverFase("0 a 5 anos", 
            "• Primeiros passos aos 8 meses\n" +
            "• Comecei a falar com 2 anos\n" +
            "• Morava no Uruguai e aos 3 anos vim para o Brasil\n" +
            "• Primeira memória: no carro com os pais vindo da fronteira (Uruguai) para Agudo-RS");

        kenedi.viverFase("5 a 7 anos",
            "• Formei amizades que tenho até hoje\n" +
            "• Aprendi a ler aos 5 quase 6 anos de idade");

        kenedi.viverFase("8 a 10 anos",
            "• Trinquei o braço brincando na escola (gesso por 1 mês)\n" +
            "• Brincava de pega-pega, esconde-esconde, bolinha de gude\n" +
            "• Queria ser Engenheiro Civil");

        kenedi.viverFase("10 a 12 anos",
            "• Primeiro computador e contato com a tecnologia");

        kenedi.viverFase("13 a 15 anos",
            "• Jogava CS:GO, GTA SA, Rocket League, Minecraft");

        kenedi.viverFase("16 a 18 anos",
            "• Era estagiário CIEE (R$ 500/mês)\n" +
            "• Comprei bicicleta, celular e juntei para CNH\n" +
            "• Me formei no ensino médio durante a pandemia");

        kenedi.viverFase("19 a 23 anos (atual)",
            "• Entrei no Exército Brasileiro (3 anos de serviço)\n" +
            "• Moro sozinho com a namorada\n" +
            "• Cursando SI na AMF (6º semestre)\n" +
            "• Ajudei a abrir negócio familiar");

        // Execução do projeto de natureza
        projeto.executarProjeto();

        // Demonstração de polimorfismo
        System.out.println("\n[OOP] === DEMONSTRACAO DE POLIMORFISMO ===");
        List<Pessoa> familia = new ArrayList<>();
        familia.add(pai);
        familia.add(mae);
        familia.add(kenedi);

        for (Pessoa pessoa : familia) {
            pessoa.apresentar();
            System.out.println("---");
        }

        // Mostrando histórico dinâmico
        kenedi.mostrarHistorico();

        // Finalização do ciclo de vida
        System.out.println("\n==========================================");
        System.out.println("[OK] Status atual: Objeto ativo e em evolucao constante!");
        System.out.println("[>>] Proxima fase: Profissional de TI + Empresario");
        System.out.println("[*] Execute novamente e escolha o modo interativo!");
        System.out.println("==========================================");
    }
}
