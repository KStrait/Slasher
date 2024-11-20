import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        setStatusBarBackgroundColor(color: .red)  // Or any color you prefer
        return MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}

    // Function to change the status bar background color
    private func setStatusBarBackgroundColor(color: UIColor) {
        if #available(iOS 13.0, *) {

            let window = UIApplication.shared.windows.first

            let topPadding = window?.safeAreaInsets.top

            let statusBar = UIView(frame: CGRect(x: 0, y: 0, width: UIScreen.main.bounds.size.width, height: topPadding ?? 0.0))

            statusBar.backgroundColor = color

            UIApplication.shared.windows.filter {$0.isKeyWindow}.first?.addSubview(statusBar)

    }

//        // Directly use the statusBarFrame, no need for optional binding
//        let statusBarFrame = UIApplication.shared.statusBarFrame
//
//        // Create and add the status bar view
//        let statusBarView = UIView(frame: statusBarFrame)
//        statusBarView.backgroundColor = color
//
//        // Ensure this is added to the keyWindow, or a valid window if working with iOS 13+
//        UIApplication.shared.keyWindow?.addSubview(statusBarView)
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .ignoresSafeArea(edges: .all) // Add this line
            .ignoresSafeArea(.keyboard)
    }
}



