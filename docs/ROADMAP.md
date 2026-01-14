# 🎬 ToonForge - Roadmap

> Gerador de vídeos animados para YouTube usando Java

Este documento descreve o plano completo de desenvolvimento do projeto, desde a configuração inicial até a publicação automática de vídeos no YouTube.

---

## 📋 Índice

- [Visão Geral](#-visão-geral)
- [Stack Tecnológica](#-stack-tecnológica)
- [Arquitetura do Projeto](#-arquitetura-do-projeto)
- [Fases de Desenvolvimento](#-fases-de-desenvolvimento)
  - [Fase 1: Fundação](#fase-1-fundação-2-3-semanas)
  - [Fase 2: Sistema de Personagens](#fase-2-sistema-de-personagens-2-3-semanas)
  - [Fase 3: Motor de Animação](#fase-3-motor-de-animação-3-4-semanas)
  - [Fase 4: Cenas e Diálogos](#fase-4-cenas-e-diálogos-2-3-semanas)
  - [Fase 5: Sistema de Áudio](#fase-5-sistema-de-áudio-2-semanas)
  - [Fase 6: Exportação de Vídeo](#fase-6-exportação-de-vídeo-1-2-semanas)
  - [Fase 7: Integração YouTube](#fase-7-integração-youtube-1-2-semanas)
  - [Fase 8: Automação e Pipeline](#fase-8-automação-e-pipeline-ongoing)
- [Pipeline de Produção](#-pipeline-de-produção)
- [Formato de Roteiro](#-formato-de-roteiro)
- [Checklist de Progresso](#-checklist-de-progresso)
- [Recursos e Referências](#-recursos-e-referências)

---

## 🎯 Visão Geral

### Objetivo
Criar uma engine em Java capaz de gerar vídeos animados com personagens no estilo minimalista (stick figures), incluindo diálogos, expressões faciais e movimentos fluidos, com upload automático para o YouTube.

### Características Principais
- Personagens articulados com partes independentes
- Sistema de animação por keyframes com interpolação suave
- Expressões faciais dinâmicas
- Balões de fala sincronizados
- Text-to-Speech integrado
- Exportação em MP4 (1080p/4K)
- Upload automático para YouTube

---

## 🛠 Stack Tecnológica

### Core
| Tecnologia | Versão | Uso |
|------------|--------|-----|
| Java | 17+ | Linguagem principal |
| Maven | 3.8+ | Gerenciamento de dependências |

### Renderização e Gráficos
| Biblioteca | Uso |
|------------|-----|
| Java2D (Graphics2D) | Desenho vetorial dos personagens |
| JavaFX | Interface de preview e timeline |

### Animação
| Biblioteca | Uso |
|------------|-----|
| Custom Engine | Sistema de keyframes próprio |
| Easing Functions | Interpolação suave (ease-in, ease-out, etc) |

### Vídeo
| Biblioteca | Uso |
|------------|-----|
| JavaCV | Wrapper do FFmpeg para encoding |
| FFmpeg | Codificação H.264/H.265 |

### Áudio
| Biblioteca | Uso |
|------------|-----|
| MaryTTS | Text-to-Speech offline |
| JavaZoom | Manipulação de MP3 |

### YouTube
| Biblioteca | Uso |
|------------|-----|
| YouTube Data API v3 | Upload e gerenciamento |
| Google OAuth2 | Autenticação |

### Utilitários
| Biblioteca | Uso |
|------------|-----|
| SnakeYAML | Parser de roteiros YAML |
| Jackson | Serialização JSON |
| SLF4J + Logback | Logging |

---

## 🏗 Arquitetura do Projeto

```
toon-forge/
├── pom.xml
├── README.md
├── ROADMAP.md
├── LICENSE
│
├── docs/
│   ├── architecture.md
│   ├── animation-guide.md
│   └── script-format.md
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/toonforge/
│   │   │       │
│   │   │       ├── ToonForgeApp.java
│   │   │       │
│   │   │       ├── core/
│   │   │       │   ├── Engine.java
│   │   │       │   ├── Timeline.java
│   │   │       │   ├── Renderer.java
│   │   │       │   └── Config.java
│   │   │       │
│   │   │       ├── character/
│   │   │       │   ├── Character.java
│   │   │       │   ├── CharacterPart.java
│   │   │       │   ├── CharacterBuilder.java
│   │   │       │   ├── CharacterStyle.java
│   │   │       │   ├── Expression.java
│   │   │       │   └── parts/
│   │   │       │       ├── Head.java
│   │   │       │       ├── Body.java
│   │   │       │       ├── Arm.java
│   │   │       │       ├── Leg.java
│   │   │       │       ├── Eye.java
│   │   │       │       └── Mouth.java
│   │   │       │
│   │   │       ├── animation/
│   │   │       │   ├── Animation.java
│   │   │       │   ├── AnimationPlayer.java
│   │   │       │   ├── Keyframe.java
│   │   │       │   ├── Interpolator.java
│   │   │       │   ├── Easing.java
│   │   │       │   └── presets/
│   │   │       │       ├── IdleAnimation.java
│   │   │       │       ├── WalkAnimation.java
│   │   │       │       ├── WaveAnimation.java
│   │   │       │       ├── TalkAnimation.java
│   │   │       │       ├── JumpAnimation.java
│   │   │       │       └── ThinkAnimation.java
│   │   │       │
│   │   │       ├── scene/
│   │   │       │   ├── Scene.java
│   │   │       │   ├── SceneManager.java
│   │   │       │   ├── SceneObject.java
│   │   │       │   ├── Background.java
│   │   │       │   ├── SpeechBubble.java
│   │   │       │   ├── Transition.java
│   │   │       │   └── Position.java
│   │   │       │
│   │   │       ├── audio/
│   │   │       │   ├── AudioManager.java
│   │   │       │   ├── TextToSpeech.java
│   │   │       │   ├── VoiceConfig.java
│   │   │       │   ├── MusicTrack.java
│   │   │       │   ├── SoundEffect.java
│   │   │       │   └── AudioMixer.java
│   │   │       │
│   │   │       ├── video/
│   │   │       │   ├── VideoExporter.java
│   │   │       │   ├── VideoConfig.java
│   │   │       │   ├── FrameBuffer.java
│   │   │       │   ├── Encoder.java
│   │   │       │   └── Resolution.java
│   │   │       │
│   │   │       ├── youtube/
│   │   │       │   ├── YouTubeService.java
│   │   │       │   ├── YouTubeUploader.java
│   │   │       │   ├── YouTubeAuth.java
│   │   │       │   ├── VideoMetadata.java
│   │   │       │   └── UploadStatus.java
│   │   │       │
│   │   │       ├── script/
│   │   │       │   ├── Script.java
│   │   │       │   ├── ScriptParser.java
│   │   │       │   ├── ScriptValidator.java
│   │   │       │   ├── Dialogue.java
│   │   │       │   └── ScriptToScene.java
│   │   │       │
│   │   │       └── util/
│   │   │           ├── ColorPalette.java
│   │   │           ├── ColorUtils.java
│   │   │           ├── MathUtils.java
│   │   │           ├── FileUtils.java
│   │   │           └── TimeUtils.java
│   │   │
│   │   └── resources/
│   │       ├── application.yml
│   │       ├── fonts/
│   │       │   └── comic-neue.ttf
│   │       ├── audio/
│   │       │   ├── music/
│   │       │   └── sfx/
│   │       ├── backgrounds/
│   │       │   ├── office.png
│   │       │   ├── home.png
│   │       │   └── outdoor.png
│   │       └── templates/
│   │           └── script-template.yml
│   │
│   └── test/
│       └── java/
│           └── com/toonforge/
│               ├── character/
│               ├── animation/
│               └── video/
│
├── scripts/
│   └── examples/
│       ├── hello-world.yml
│       └── conversation.yml
│
└── output/
    ├── videos/
    └── frames/
```

---

## 🚀 Fases de Desenvolvimento

### Fase 1: Fundação (2-3 semanas)

**Objetivo:** Configurar o ambiente e criar a estrutura básica de renderização.

#### Tarefas

| # | Tarefa | Descrição | Prioridade |
|---|--------|-----------|------------|
| 1.1 | Setup Maven | Criar `pom.xml` com dependências iniciais | Alta |
| 1.2 | Estrutura de pastas | Criar arquitetura de pacotes | Alta |
| 1.3 | Classe Main | Entry point da aplicação | Alta |
| 1.4 | Preview Window | Janela Swing/JavaFX para visualização | Alta |
| 1.5 | Renderer básico | Classe para renderizar em BufferedImage | Alta |
| 1.6 | Teste de exportação | Salvar frame como PNG | Média |
| 1.7 | Configuração | Sistema de configuração (YAML) | Média |
| 1.8 | Logging | Configurar SLF4J + Logback | Baixa |

#### Entregáveis
- [x] Projeto Maven funcional
- [x] Janela de preview abrindo
- [x] Capacidade de desenhar formas básicas
- [x] Exportar imagem PNG

#### Dependências (pom.xml)
```xml
<!-- Java2D - nativo -->
<!-- JavaFX -->
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>21</version>
</dependency>
<!-- Configuração -->
<dependency>
    <groupId>org.yaml</groupId>
    <artifactId>snakeyaml</artifactId>
    <version>2.0</version>
</dependency>
<!-- Logging -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.4.11</version>
</dependency>
```

---

### Fase 2: Sistema de Personagens (2-3 semanas)

**Objetivo:** Criar personagens articulados com partes independentes e customizáveis.

#### Tarefas

| # | Tarefa | Descrição | Prioridade |
|---|--------|-----------|------------|
| 2.1 | CharacterPart | Classe base para partes do corpo | Alta |
| 2.2 | Transformações | Sistema de posição, rotação, escala | Alta |
| 2.3 | Pivot points | Pontos de rotação para articulações | Alta |
| 2.4 | Head | Implementar cabeça (círculo) | Alta |
| 2.5 | Body | Implementar corpo (retângulo arredondado) | Alta |
| 2.6 | Arms | Implementar braços (curvas) | Alta |
| 2.7 | Legs | Implementar pernas (linhas) | Alta |
| 2.8 | Eyes | Implementar olhos (linhas/formas) | Alta |
| 2.9 | Mouth | Implementar boca (linha/arco) | Alta |
| 2.10 | Character | Classe que agrupa todas as partes | Alta |
| 2.11 | Expression enum | Enum com expressões (NEUTRAL, HAPPY, SAD, etc) | Alta |
| 2.12 | setExpression() | Método para mudar expressão facial | Alta |
| 2.13 | CharacterBuilder | Builder pattern para criar personagens | Média |
| 2.14 | CharacterStyle | Estilos predefinidos de personagens | Média |
| 2.15 | Cores customizáveis | Sistema de paleta de cores | Média |

#### Entregáveis
- [ ] Classe CharacterPart funcional com transformações
- [ ] Classe Character completa com todas as partes
- [ ] Sistema de expressões faciais (mínimo 5 expressões)
- [ ] CharacterBuilder para criar variações
- [ ] Renderizar 2+ personagens diferentes na tela

#### Diagrama de Classes

```
CharacterPart (abstract)
├── shape: Shape
├── fillColor: Color
├── strokeColor: Color
├── strokeWidth: float
├── x, y: double
├── rotation: double
├── scaleX, scaleY: double
├── pivotX, pivotY: double
├── draw(Graphics2D): void
└── setTransform(...): void

Character
├── parts: Map<String, CharacterPart>
├── head: Head
├── body: Body
├── leftArm, rightArm: Arm
├── leftLeg, rightLeg: Leg
├── leftEye, rightEye: Eye
├── mouth: Mouth
├── expression: Expression
├── draw(Graphics2D, x, y): void
├── setExpression(Expression): void
└── getPart(String): CharacterPart

Expression (enum)
├── NEUTRAL
├── HAPPY
├── SAD
├── SURPRISED
├── ANGRY
├── THINKING
└── CONFUSED
```

---

### Fase 3: Motor de Animação (3-4 semanas)

**Objetivo:** Criar sistema de animação por keyframes com interpolação suave.

#### Tarefas

| # | Tarefa | Descrição | Prioridade |
|---|--------|-----------|------------|
| 3.1 | Keyframe | Classe para representar estado em um momento | Alta |
| 3.2 | Animation | Classe que contém lista de keyframes | Alta |
| 3.3 | Timeline | Gerenciador de tempo da animação | Alta |
| 3.4 | Interpolator | Interpolação entre keyframes | Alta |
| 3.5 | Linear interp | Interpolação linear básica | Alta |
| 3.6 | Easing enum | Enum com funções de easing | Alta |
| 3.7 | Ease-in | Início lento, fim rápido | Alta |
| 3.8 | Ease-out | Início rápido, fim lento | Alta |
| 3.9 | Ease-in-out | Lento nas pontas | Alta |
| 3.10 | Bounce | Efeito de "quicar" | Média |
| 3.11 | Elastic | Efeito elástico | Média |
| 3.12 | AnimationPlayer | Reprodutor de animações | Alta |
| 3.13 | IdleAnimation | Animação de respiração/idle | Alta |
| 3.14 | WaveAnimation | Animação de acenar | Alta |
| 3.15 | WalkAnimation | Animação de caminhar | Alta |
| 3.16 | TalkAnimation | Animação de boca falando | Alta |
| 3.17 | JumpAnimation | Animação de pular | Média |
| 3.18 | ThinkAnimation | Animação de pensar | Média |
| 3.19 | Animation blending | Combinar animações | Baixa |

#### Entregáveis
- [ ] Sistema de keyframes funcional
- [ ] Interpolação suave entre estados
- [ ] Mínimo 6 animações predefinidas
- [ ] Funções de easing implementadas
- [ ] Demo: personagem andando em loop

#### Conceitos de Animação

```
Keyframe
├── time: double (segundos)
├── properties: Map<String, Double>
│   ├── "leftArm.rotation" → 45.0
│   ├── "rightArm.rotation" → -30.0
│   ├── "head.y" → 5.0
│   └── ...
└── easing: Easing

Animation
├── name: String
├── duration: double
├── keyframes: List<Keyframe>
├── loop: boolean
├── getValueAt(property, time): double
└── apply(Character, time): void

Easing (enum)
├── LINEAR
├── EASE_IN (quad)
├── EASE_OUT (quad)
├── EASE_IN_OUT (quad)
├── EASE_IN_CUBIC
├── EASE_OUT_CUBIC
├── EASE_IN_OUT_CUBIC
├── BOUNCE
└── ELASTIC
```

#### Fórmulas de Easing
```java
// Linear
t → t

// Ease In (Quad)
t → t * t

// Ease Out (Quad)
t → t * (2 - t)

// Ease In Out (Quad)
t → t < 0.5 ? 2 * t * t : -1 + (4 - 2 * t) * t

// Bounce
t → {
    if (t < 1/2.75) return 7.5625 * t * t;
    else if (t < 2/2.75) return 7.5625 * (t -= 1.5/2.75) * t + 0.75;
    else if (t < 2.5/2.75) return 7.5625 * (t -= 2.25/2.75) * t + 0.9375;
    else return 7.5625 * (t -= 2.625/2.75) * t + 0.984375;
}
```

---

### Fase 4: Cenas e Diálogos (2-3 semanas)

**Objetivo:** Criar sistema de cenas com múltiplos personagens, diálogos e cenários.

#### Tarefas

| # | Tarefa | Descrição | Prioridade |
|---|--------|-----------|------------|
| 4.1 | Scene | Classe que representa uma cena | Alta |
| 4.2 | SceneManager | Gerenciador de múltiplas cenas | Alta |
| 4.3 | SceneObject | Classe base para objetos na cena | Alta |
| 4.4 | Background | Sistema de cenários/fundos | Alta |
| 4.5 | Position enum | Posições predefinidas (LEFT, CENTER, RIGHT) | Alta |
| 4.6 | SpeechBubble | Balões de fala | Alta |
| 4.7 | Bubble styles | Estilos de balão (fala, pensamento, grito) | Média |
| 4.8 | Text rendering | Renderização de texto nos balões | Alta |
| 4.9 | Word wrap | Quebra de linha automática | Alta |
| 4.10 | Transition | Transições entre cenas | Média |
| 4.11 | Fade transition | Fade in/out | Média |
| 4.12 | Slide transition | Slide esquerda/direita | Média |
| 4.13 | Script class | Classe para roteiro completo | Alta |
| 4.14 | ScriptParser | Parser de YAML para Script | Alta |
| 4.15 | ScriptValidator | Validação de roteiros | Média |
| 4.16 | ScriptToScene | Conversor de roteiro para cenas | Alta |

#### Entregáveis
- [ ] Sistema de cenas funcional
- [ ] Backgrounds carregando corretamente
- [ ] Balões de fala renderizando
- [ ] Parser de roteiro YAML funcionando
- [ ] Demo: cena com 2 personagens conversando

#### Estrutura de Cena

```
Scene
├── id: String
├── duration: double
├── background: Background
├── characters: List<SceneCharacter>
│   └── SceneCharacter
│       ├── character: Character
│       ├── position: Position
│       ├── animations: List<AnimationTrigger>
│       └── dialogues: List<Dialogue>
├── objects: List<SceneObject>
├── transitions: Transition (in/out)
└── render(Graphics2D, time): void

Dialogue
├── text: String
├── startTime: double
├── duration: double
├── bubbleStyle: BubbleStyle
└── voiceConfig: VoiceConfig

Position (enum)
├── LEFT (-300, 0)
├── CENTER (0, 0)
├── RIGHT (300, 0)
├── FAR_LEFT (-500, 0)
└── FAR_RIGHT (500, 0)
```

---

### Fase 5: Sistema de Áudio (2 semanas)

**Objetivo:** Integrar Text-to-Speech e música de fundo.

#### Tarefas

| # | Tarefa | Descrição | Prioridade |
|---|--------|-----------|------------|
| 5.1 | AudioManager | Gerenciador central de áudio | Alta |
| 5.2 | MaryTTS setup | Configurar MaryTTS | Alta |
| 5.3 | TextToSpeech | Classe wrapper para TTS | Alta |
| 5.4 | VoiceConfig | Configuração de voz (pitch, speed) | Média |
| 5.5 | Vozes diferentes | Vozes distintas por personagem | Média |
| 5.6 | Lip sync | Sincronizar boca com áudio | Alta |
| 5.7 | MusicTrack | Classe para música de fundo | Média |
| 5.8 | SoundEffect | Classe para efeitos sonoros | Baixa |
| 5.9 | AudioMixer | Mixagem de múltiplas trilhas | Alta |
| 5.10 | Volume control | Controle de volume por trilha | Média |
| 5.11 | Fade audio | Fade in/out de áudio | Média |
| 5.12 | Export audio | Exportar áudio final | Alta |

#### Entregáveis
- [ ] TTS gerando áudio a partir de texto
- [ ] Sincronização básica de lábios
- [ ] Música de fundo tocando
- [ ] Mixer combinando voz + música
- [ ] Demo: personagem falando com áudio

#### Configuração MaryTTS
```xml
<dependency>
    <groupId>de.dfki.mary</groupId>
    <artifactId>marytts-runtime</artifactId>
    <version>5.2.1</version>
</dependency>
<dependency>
    <groupId>de.dfki.mary</groupId>
    <artifactId>voice-cmu-slt-hsmm</artifactId>
    <version>5.2</version>
</dependency>
```

---

### Fase 6: Exportação de Vídeo (1-2 semanas)

**Objetivo:** Renderizar animação para arquivo MP4.

#### Tarefas

| # | Tarefa | Descrição | Prioridade |
|---|--------|-----------|------------|
| 6.1 | JavaCV setup | Configurar JavaCV/FFmpeg | Alta |
| 6.2 | VideoConfig | Configurações de vídeo | Alta |
| 6.3 | Resolution enum | Resoluções predefinidas | Média |
| 6.4 | FrameBuffer | Buffer de frames | Alta |
| 6.5 | Frame rendering | Renderizar frames sequenciais | Alta |
| 6.6 | Encoder | Encoding H.264 | Alta |
| 6.7 | Add audio | Adicionar trilha de áudio | Alta |
| 6.8 | VideoExporter | Classe principal de exportação | Alta |
| 6.9 | Progress callback | Callback de progresso | Média |
| 6.10 | Quality presets | Presets de qualidade | Média |

#### Entregáveis
- [ ] Frames sendo gerados corretamente
- [ ] Vídeo MP4 sendo criado
- [ ] Áudio sincronizado no vídeo
- [ ] Suporte a 1080p e 4K
- [ ] Demo: vídeo de 30 segundos exportado

#### Configuração JavaCV
```xml
<dependency>
    <groupId>org.bytedeco</groupId>
    <artifactId>javacv-platform</artifactId>
    <version>1.5.9</version>
</dependency>
```

#### Resoluções Suportadas
| Nome | Largura | Altura | FPS | Bitrate |
|------|---------|--------|-----|---------|
| 720p | 1280 | 720 | 30 | 5 Mbps |
| 1080p | 1920 | 1080 | 30 | 10 Mbps |
| 1080p60 | 1920 | 1080 | 60 | 15 Mbps |
| 4K | 3840 | 2160 | 30 | 35 Mbps |

---

### Fase 7: Integração YouTube (1-2 semanas)

**Objetivo:** Upload automático de vídeos para o YouTube.

#### Tarefas

| # | Tarefa | Descrição | Prioridade |
|---|--------|-----------|------------|
| 7.1 | Google Cloud | Criar projeto no Google Cloud | Alta |
| 7.2 | API habilitada | Habilitar YouTube Data API v3 | Alta |
| 7.3 | OAuth credentials | Criar credenciais OAuth2 | Alta |
| 7.4 | YouTubeAuth | Classe de autenticação | Alta |
| 7.5 | Token storage | Armazenar/renovar tokens | Alta |
| 7.6 | VideoMetadata | Classe para metadados | Alta |
| 7.7 | YouTubeUploader | Classe de upload | Alta |
| 7.8 | Upload resumable | Upload com retry | Média |
| 7.9 | UploadStatus | Status e progresso | Média |
| 7.10 | Thumbnail | Upload de thumbnail | Média |
| 7.11 | Playlist | Adicionar a playlists | Baixa |
| 7.12 | Schedule | Agendar publicação | Baixa |

#### Entregáveis
- [ ] Autenticação OAuth2 funcionando
- [ ] Upload de vídeo bem-sucedido
- [ ] Metadados sendo aplicados
- [ ] Thumbnail customizada
- [ ] Demo: upload automático completo

#### Configuração YouTube API
```xml
<dependency>
    <groupId>com.google.apis</groupId>
    <artifactId>google-api-services-youtube</artifactId>
    <version>v3-rev20231011-2.0.0</version>
</dependency>
<dependency>
    <groupId>com.google.oauth-client</groupId>
    <artifactId>google-oauth-client-jetty</artifactId>
    <version>1.34.1</version>
</dependency>
```

#### Estrutura de Metadados
```java
VideoMetadata
├── title: String
├── description: String
├── tags: List<String>
├── categoryId: String (ex: "24" = Entertainment)
├── privacyStatus: PrivacyStatus (PUBLIC, PRIVATE, UNLISTED)
├── thumbnailPath: String
├── playlistId: String (opcional)
├── scheduledAt: LocalDateTime (opcional)
└── language: String
```

---

### Fase 8: Automação e Pipeline (Ongoing)

**Objetivo:** Automatizar todo o processo de geração e publicação.

#### Tarefas

| # | Tarefa | Descrição | Prioridade |
|---|--------|-----------|------------|
| 8.1 | CLI | Interface de linha de comando | Alta |
| 8.2 | Config file | Arquivo de configuração global | Alta |
| 8.3 | Batch processing | Processar múltiplos roteiros | Média |
| 8.4 | Scheduler | Agendador de tarefas | Média |
| 8.5 | Logging | Logs detalhados | Média |
| 8.6 | Error handling | Tratamento robusto de erros | Alta |
| 8.7 | Retry logic | Retry em falhas | Média |
| 8.8 | Notifications | Notificações (email/Discord) | Baixa |
| 8.9 | Dashboard | Interface web de monitoramento | Baixa |
| 8.10 | AI scripts | Integração com ChatGPT/Claude | Baixa |

#### Entregáveis
- [ ] CLI funcional
- [ ] Pipeline end-to-end automatizado
- [ ] Logs e monitoramento
- [ ] Documentação completa

#### Comandos CLI
```bash
# Gerar vídeo a partir de roteiro
toonforge generate --script video.yml --output video.mp4

# Gerar e fazer upload
toonforge publish --script video.yml

# Preview sem exportar
toonforge preview --script video.yml

# Validar roteiro
toonforge validate --script video.yml

# Listar vozes disponíveis
toonforge voices --list

# Listar animações disponíveis
toonforge animations --list
```

---

## 🔄 Pipeline de Produção

```
┌─────────────────────────────────────────────────────────────────────────┐
│                           PIPELINE COMPLETO                              │
└─────────────────────────────────────────────────────────────────────────┘

     ┌──────────┐
     │  ROTEIRO │ (YAML/JSON)
     │          │
     │ - cenas  │
     │ - falas  │
     │ - ações  │
     └────┬─────┘
          │
          ▼
     ┌──────────┐
     │  PARSER  │ ScriptParser.java
     │          │
     │ - valida │
     │ - converte│
     └────┬─────┘
          │
          ▼
     ┌──────────┐
     │  SCENES  │ SceneManager.java
     │          │
     │ - cria   │
     │   cenas  │
     │ - config │
     │   chars  │
     └────┬─────┘
          │
          ├─────────────────────────────────┐
          │                                 │
          ▼                                 ▼
     ┌──────────┐                     ┌──────────┐
     │  RENDER  │                     │   TTS    │ TextToSpeech.java
     │          │                     │          │
     │ - frames │                     │ - gera   │
     │ - anima  │                     │   áudio  │
     │ - 30fps  │                     │ - vozes  │
     └────┬─────┘                     └────┬─────┘
          │                                 │
          │                                 │
          ▼                                 ▼
     ┌──────────┐                     ┌──────────┐
     │  BUFFER  │                     │  MUSIC   │
     │          │                     │          │
     │ - PNG    │                     │ - BGM    │
     │   frames │                     │ - SFX    │
     └────┬─────┘                     └────┬─────┘
          │                                 │
          └────────────┬────────────────────┘
                       │
                       ▼
                  ┌──────────┐
                  │  MIXER   │ AudioMixer.java
                  │          │
                  │ - combina│
                  │   trilhas│
                  └────┬─────┘
                       │
                       ▼
                  ┌──────────┐
                  │ ENCODER  │ VideoExporter.java
                  │          │
                  │ - H.264  │
                  │ - MP4    │
                  └────┬─────┘
                       │
                       ▼
                  ┌──────────┐
                  │  VIDEO   │ output/video.mp4
                  │  .MP4    │
                  └────┬─────┘
                       │
                       ▼
                  ┌──────────┐
                  │ YOUTUBE  │ YouTubeUploader.java
                  │          │
                  │ - upload │
                  │ - meta   │
                  │ - thumb  │
                  └────┬─────┘
                       │
                       ▼
                  ┌──────────┐
                  │ PUBLICADO│ 🎉
                  │          │
                  └──────────┘
```

---

## 📝 Formato de Roteiro

### Estrutura YAML Completa

```yaml
# ============================================
# TOONFORGE - Script Format v1.0
# ============================================

# Metadados do vídeo
video:
  title: "Título do Vídeo"
  description: |
    Descrição completa do vídeo.
    Pode ter múltiplas linhas.
  tags:
    - programação
    - humor
    - dev
  category: entertainment  # entertainment, education, etc
  language: pt-BR
  
# Configurações técnicas
settings:
  resolution: 1080p  # 720p, 1080p, 4k
  fps: 30
  background_music: "music/chill-beat.mp3"
  music_volume: 0.3

# Definição de personagens
characters:
  - id: dev1
    name: "João"
    style: default
    colors:
      shirt: "#4A90D9"
      skin: "#FAF5F0"
    voice:
      engine: marytts
      voice: cmu-slt-hsmm
      pitch: 1.0
      speed: 1.0
      
  - id: dev2
    name: "Maria"
    style: default
    colors:
      shirt: "#D94A4A"
      skin: "#FAF5F0"
    voice:
      engine: marytts
      voice: cmu-slt-hsmm
      pitch: 1.2
      speed: 1.1

# Sequência de cenas
scenes:
  # === CENA 1 ===
  - id: intro
    duration: 5s
    background: office
    transition_in: fade
    transition_out: none
    
    characters:
      - id: dev1
        position: left
        initial_expression: neutral
        
      - id: dev2
        position: right
        initial_expression: neutral
    
    timeline:
      # Diálogo
      - type: dialogue
        character: dev1
        text: "E aí, terminou aquele código?"
        start: 0s
        bubble: speech
        
      # Mudança de expressão
      - type: expression
        character: dev2
        expression: thinking
        start: 2s
        
      # Animação
      - type: animation
        character: dev2
        animation: think
        start: 2s
        duration: 2s
        
      # Resposta
      - type: dialogue
        character: dev2
        text: "Hmm... mais ou menos..."
        start: 2.5s
        bubble: speech

  # === CENA 2 ===
  - id: reveal
    duration: 4s
    background: office
    transition_in: slide_left
    
    characters:
      - id: dev1
        position: center
        initial_expression: surprised
    
    timeline:
      - type: dialogue
        character: dev1
        text: "Compilou de primeira?!"
        start: 0s
        bubble: shout
        
      - type: animation
        character: dev1
        animation: jump
        start: 0.5s
        duration: 1s
        
      - type: expression
        character: dev1
        expression: happy
        start: 1.5s

# Créditos finais (opcional)
credits:
  show: true
  duration: 3s
  text: |
    Criado com ToonForge
    github.com/user/toon-forge
```

### Referência de Valores

#### Expressões
```
neutral, happy, sad, surprised, angry, thinking, confused, excited, tired, scared
```

#### Animações
```
idle, walk, wave, talk, jump, think, nod, shake_head, shrug, point, clap, dance
```

#### Posições
```
far_left, left, center_left, center, center_right, right, far_right
```

#### Estilos de Balão
```
speech      → Balão normal de fala
thought     → Balão de pensamento (nuvem)
shout       → Balão de grito (pontas)
whisper     → Balão pontilhado
narration   → Caixa de narração (topo da tela)
```

#### Transições
```
none, fade, slide_left, slide_right, slide_up, slide_down, zoom_in, zoom_out
```

---

## ✅ Checklist de Progresso

### Fase 1: Fundação
- [ ] 1.1 Setup Maven completo
- [ ] 1.2 Estrutura de pastas criada
- [ ] 1.3 Classe Main funcionando
- [ ] 1.4 Preview Window abrindo
- [ ] 1.5 Renderer básico desenhando
- [ ] 1.6 Exportação PNG funcionando
- [ ] 1.7 Sistema de configuração
- [ ] 1.8 Logging configurado

### Fase 2: Sistema de Personagens
- [ ] 2.1 CharacterPart implementado
- [ ] 2.2 Sistema de transformações
- [ ] 2.3 Pivot points funcionando
- [ ] 2.4 Head implementado
- [ ] 2.5 Body implementado
- [ ] 2.6 Arms implementados
- [ ] 2.7 Legs implementados
- [ ] 2.8 Eyes implementados
- [ ] 2.9 Mouth implementado
- [ ] 2.10 Character completo
- [ ] 2.11 Expression enum criado
- [ ] 2.12 setExpression() funcionando
- [ ] 2.13 CharacterBuilder criado
- [ ] 2.14 CharacterStyle implementado
- [ ] 2.15 Cores customizáveis

### Fase 3: Motor de Animação
- [ ] 3.1 Keyframe implementado
- [ ] 3.2 Animation implementado
- [ ] 3.3 Timeline funcionando
- [ ] 3.4 Interpolator básico
- [ ] 3.5 Interpolação linear
- [ ] 3.6 Easing enum
- [ ] 3.7 Ease-in implementado
- [ ] 3.8 Ease-out implementado
- [ ] 3.9 Ease-in-out implementado
- [ ] 3.10 Bounce implementado
- [ ] 3.11 Elastic implementado
- [ ] 3.12 AnimationPlayer funcionando
- [ ] 3.13 IdleAnimation
- [ ] 3.14 WaveAnimation
- [ ] 3.15 WalkAnimation
- [ ] 3.16 TalkAnimation
- [ ] 3.17 JumpAnimation
- [ ] 3.18 ThinkAnimation
- [ ] 3.19 Animation blending

### Fase 4: Cenas e Diálogos
- [ ] 4.1 Scene implementado
- [ ] 4.2 SceneManager funcionando
- [ ] 4.3 SceneObject base
- [ ] 4.4 Background carregando
- [ ] 4.5 Position enum
- [ ] 4.6 SpeechBubble renderizando
- [ ] 4.7 Estilos de balão
- [ ] 4.8 Text rendering
- [ ] 4.9 Word wrap funcionando
- [ ] 4.10 Transition base
- [ ] 4.11 Fade transition
- [ ] 4.12 Slide transition
- [ ] 4.13 Script class
- [ ] 4.14 ScriptParser YAML
- [ ] 4.15 ScriptValidator
- [ ] 4.16 ScriptToScene

### Fase 5: Sistema de Áudio
- [ ] 5.1 AudioManager
- [ ] 5.2 MaryTTS configurado
- [ ] 5.3 TextToSpeech wrapper
- [ ] 5.4 VoiceConfig
- [ ] 5.5 Vozes por personagem
- [ ] 5.6 Lip sync básico
- [ ] 5.7 MusicTrack
- [ ] 5.8 SoundEffect
- [ ] 5.9 AudioMixer
- [ ] 5.10 Volume control
- [ ] 5.11 Fade audio
- [ ] 5.12 Export audio

### Fase 6: Exportação de Vídeo
- [ ] 6.1 JavaCV configurado
- [ ] 6.2 VideoConfig
- [ ] 6.3 Resolution enum
- [ ] 6.4 FrameBuffer
- [ ] 6.5 Frame rendering
- [ ] 6.6 H.264 encoding
- [ ] 6.7 Áudio no vídeo
- [ ] 6.8 VideoExporter
- [ ] 6.9 Progress callback
- [ ] 6.10 Quality presets

### Fase 7: Integração YouTube
- [ ] 7.1 Google Cloud projeto
- [ ] 7.2 YouTube API habilitada
- [ ] 7.3 OAuth credentials
- [ ] 7.4 YouTubeAuth
- [ ] 7.5 Token storage
- [ ] 7.6 VideoMetadata
- [ ] 7.7 YouTubeUploader
- [ ] 7.8 Upload resumable
- [ ] 7.9 UploadStatus
- [ ] 7.10 Thumbnail upload
- [ ] 7.11 Playlist support
- [ ] 7.12 Schedule publish

### Fase 8: Automação
- [ ] 8.1 CLI implementado
- [ ] 8.2 Config file global
- [ ] 8.3 Batch processing
- [ ] 8.4 Scheduler
- [ ] 8.5 Logging completo
- [ ] 8.6 Error handling
- [ ] 8.7 Retry logic
- [ ] 8.8 Notifications
- [ ] 8.9 Dashboard web
- [ ] 8.10 AI integration

---

## 📚 Recursos e Referências

### Documentação Oficial
- [Java2D Tutorial](https://docs.oracle.com/javase/tutorial/2d/)
- [JavaFX Documentation](https://openjfx.io/)
- [JavaCV GitHub](https://github.com/bytedeco/javacv)
- [MaryTTS](http://mary.dfki.de/)
- [YouTube Data API v3](https://developers.google.com/youtube/v3)

### Tutoriais Recomendados
- [Animation Principles](https://en.wikipedia.org/wiki/Twelve_basic_principles_of_animation)
- [Easing Functions](https://easings.net/)
- [FFmpeg Encoding Guide](https://trac.ffmpeg.org/wiki/Encode/H.264)

### Ferramentas de Apoio
- [Inkscape](https://inkscape.org/) - Design de personagens
- [Audacity](https://www.audacityteam.org/) - Edição de áudio
- [FFmpeg](https://ffmpeg.org/) - Manipulação de vídeo

---

## 📄 Licença

Este projeto está sob a licença MIT.

---

## 🤝 Contribuições

Contribuições são bem-vindas! Por favor, leia o [CONTRIBUTING.md](CONTRIBUTING.md) antes de enviar PRs.

---

**Última atualização:** Janeiro 2026

**Versão do Roadmap:** 1.0.0
