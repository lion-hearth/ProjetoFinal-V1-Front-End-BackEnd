 function submitSuggestion() {
        var suggestionText = document.getElementById("comment").value;

        // Use AJAX para enviar a sugestão para o back-end
        axios.post('/api/suggestions', { suggestion: suggestionText })
            .then(function (response) {
                alert(response.data); // Exibir uma mensagem de sucesso
            })
            .catch(function (error) {
                console.error(error); // Lidar com erros, se houver