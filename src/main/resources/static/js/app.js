// validación de monto
document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form[action="/blocks"]');
    if (form) form.addEventListener('submit', e => {
        const amt = parseFloat(document.querySelector('input[name="amount"]').value);
        if (isNaN(amt) || amt <= 0) {
            e.preventDefault();
            alert('Monto debe ser > 0');
        }
    });
});
