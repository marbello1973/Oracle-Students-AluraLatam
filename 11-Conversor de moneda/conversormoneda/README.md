# Consumo de API de Tasas de Cambio

Este proyecto tiene como objetivo desarrollar una aplicación de consola que consuma la API de tasas de cambio para obtener información actualizada sobre las conversiones de divisas.

## Descripción

La API de tasas de cambio proporciona tasas de conversión actualizadas entre diferentes monedas. Utiliza el código base USD y ofrece conversiones a una amplia variedad de monedas internacionales.

## Documentación

Puedes encontrar la documentación completa de la API [aquí](https://www.exchangerate-api.com/docs).

## Términos de Uso

Asegúrate de revisar los términos de uso de la API [aquí](https://www.exchangerate-api.com/terms) antes de utilizarla en tu proyecto.

## Última Actualización

La información más reciente de la API fue actualizada en **Sat, 13 Apr 2024 00:00:01 +0000**.

## Uso

Este proyecto incluirá el desarrollo de una aplicación de consola que consuma la API de tasas de cambio. La aplicación permitirá a los usuarios realizar consultas de conversión de divisas y mostrará los resultados en la consola.

## Ejemplo de Consulta

Aquí tienes un ejemplo de cómo realizar una consulta a la API:

```bash
curl -X GET "https://api.exchangerate-api.com/v4/latest/USD" -H "apiKey: {inserta_tu_api_key_aquí}"