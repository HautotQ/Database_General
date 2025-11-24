import SwiftUI
import WebKit

// --- WebView pour SwiftUI ---
struct JSWebView: UIViewRepresentable {
    let jsFileName: String // nom du fichier JS (sans extension)

    func makeUIView(context: Context) -> WKWebView {
        let webView = WKWebView()
        
        // Charger un HTML minimal qui inclut le JS
        if let htmlPath = Bundle.main.path(forResource: "index", ofType: "html") {
            let htmlURL = URL(fileURLWithPath: htmlPath)
            webView.loadFileURL(htmlURL, allowingReadAccessTo: htmlURL.deletingLastPathComponent())
        }
        
        return webView
    }

    func updateUIView(_ uiView: WKWebView, context: Context) { }
}

// --- Contenu SwiftUI ---
struct ContentView: View {
    var body: some View {
        JSWebView(jsFileName: "main") // nom du JS
            .edgesIgnoringSafeArea(.all)
    }
}
