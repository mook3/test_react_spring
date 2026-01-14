import { useState } from "react";

function App() {
    const [posts, setPosts] = useState([]);
    const [error, setError] = useState(null);

    const fetchPosts = async () => {
        try {
            //const response = await fetch("http://localhost:8080/posts");
            const response = await fetch("/api/posts");
            if (!response.ok) {
                throw new Error("Request failed");
            }
            const data = await response.json();
            setPosts(data);
            setError(undefined);
        } catch (err) {
            setError(err.message);
        }
    };

    const handleSubmit = async (formData) => {
        const title = formData.get('title');
        const content = formData.get('content');

        await fetch('/api/posts', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                title: title,
                content: content,
            })
        })
        await fetchPosts();
    }

    return (
        <div style={{ padding: "2rem" }}>
            <h1>Spring + React</h1>

            <button onClick={fetchPosts}>
                Load Posts
            </button>

            {error && <p style={{ color: "red" }}>{error}</p>}

            <ul>
                {posts.map(post => (
                    <li key={post.id}>
                        <strong>{post.title}</strong>: {post.content}
                    </li>
                ))}
            </ul>

            <form action={handleSubmit}>
                <label>
                    Title:
                    <input type="text" name="title" />
                </label>
                <label>
                    Content:
                    <input type="text" name="content" />
                </label>
                <input type="submit" value="Submit" />
            </form>
        </div>
    );
}

export default App;
