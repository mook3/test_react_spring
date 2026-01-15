import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
      proxy: {
        "/api": {
          target: "http://hello.local",
          changeOrigin: true,
// needed this before changing backend from /posts to /api/posts
//          rewrite: (path) => path.replace(/^\/api/, "")
        }
      }
    }
})
