# Androidnativclareza

Projeto Android nativo gerado pela migração do app web "Clareza Financeira".

Branch de trabalho: android-native-migration

Status inicial:
- Projeto Android (Kotlin + Jetpack Compose) esqueleto criado.
- Models (types.ts) convertidos para data classes Kotlin em app/src/main/java/com/wenderson676/clarezaapkandroidv1/models/Models.kt
- MainActivity com estrutura Compose e Navigation/BottomNavigation placeholders.
- MainViewModel com estado inicial e exemplo de addTransaction.
- Retrofit ApiClient placeholder.

Próximos passos (em commits seguintes):
- Port completo de App.tsx e todos os componentes para Compose.
- Implementação completa de store (DataStore), persistência, import/export de backup, e funcionalidades: câmera (CameraX), biometria (BiometricPrompt), notificações, integração com WhatsApp/compartilhamento, e demais features encontradas no app web.
- Copiar assets (imagens/fonts) do repositório web para res/ e assets/.
- Adicionar testes e workflow GitHub Actions para build APK debug.

Observação: Este commit inicial cria a base do projeto Android e migrará gradualmente cada tela/funcionalidade preservando o comportamento do app web.
