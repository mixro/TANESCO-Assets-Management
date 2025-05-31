document.addEventListener('DOMContentLoaded', () => {
    // Hamburger menu toggle
    const toggle = document.querySelector('.navbar-toggle');
    const navLinks = document.querySelector('.navbar-links');

    if (toggle && navLinks) {
        toggle.addEventListener('click', () => {
            navLinks.classList.toggle('active');
        });
    }

    // Client-side search functionality
    const searchInput = document.getElementById('searchInput');
    const productCards = document.querySelectorAll('.product-card');

    if (searchInput && productCards.length > 0) {
        console.log(`Found ${productCards.length} product cards`);

        // Log data attributes for debugging
        productCards.forEach(card => {
            console.log(`Card: name=${card.getAttribute('data-name')}, category=${card.getAttribute('data-category')}`);
        });

        searchInput.addEventListener('input', () => {
            const searchTerm = searchInput.value.trim().toLowerCase();
            console.log(`Search term: ${searchTerm}`);

            productCards.forEach(card => {
                const name = (card.getAttribute('data-name') || '').toLowerCase();
                const category = (card.getAttribute('data-category') || '').toLowerCase();

                if (!searchTerm || name.includes(searchTerm) || category.includes(searchTerm)) {
                    card.style.display = 'block';
                } else {
                    card.style.display = 'none';
                }
            });
        });
    } else {
        console.warn('Search input or product cards not found');
    }
});