
## HEADINGS
# This is a heading 1 
## This is a heading 2 
### This is a heading 3 
#### This is a heading 4
##### This is a heading 5 
###### This is a heading 6

## PÁRRAFOS

This is a paragraph.

This is another paragraph.

## SALTOS DE LÍNEA

This is a line.  
This is another line.

## FORMATEO DE TEXTO

**Bold text**

*Italic text*

~~Striked out text~~

**Bold text and _nested italic_ text**

***Bold and italic text***

## FLECHAS

&uarr;
&darr;
&larr;
&rarr;
&harr;

## CITAR TEXTO

> Human beings face ever more complex and urgent problems, and their effectiveness in dealing with these problems is a matter that is critical to the stability and continued progress of society. 
> 
> \- Doug Engelbart, 1961

## CÓDIGO

### Código en línea

Text inside `backticks` on a line will be formatted like code.

### Bloques de código

\- Con tres barras invertidas:

```
cd ~/Desktop
```
\-  Con tabulador / 4 espacios:

    cd ~/Desktop

\- Con resaltado de lenguaje de programación específico:

```js 
function fancyAlert(arg) {
  if(arg) {
	$.facebox({div:'#foo'}) 
  }
}
```

## LINKS

### Externos

- URL sin espacios:

[Obsidian Help](https://help.obsidian.md)

- URL con espacios:

[Link caption](<https://duckduckgo.com/?q=test this!&t=ffab>)

### Internos

[Link fichero interno](Link%20interno.md)

## IMÁGENES

### Externa

![Engelbart](https://history-computer.com/ModernComputer/Basis/images/Engelbart.jpg)


### Seleccionando dimensiones
* Alto x ancho:
![Engelbart|100x145](https://history-computer.com/ModernComputer/Basis/images/Engelbart.jpg)

* Sólo ancho (la imagen escala el alto acorde al aspect ratio original):
![Engelbart|150](https://history-computer.com/ModernComputer/Basis/images/Engelbart.jpg)

### Interna
![charmander](img/charmander.png)

## BARRA HORIZONTAL

***

## LISTAS

### Desordenadas

- First list item
- Second list item 
- Third list item
### Ordenadas

1. First list item 
2. Second list item 
3. Third list item

### Anidadas

1. First list item 
	1. Ordered nested list item 
2. Second list item
	- Unordered nested list item

### De tareas

- [x] This is a completed task. 
- [ ] This is an incomplete task.

## TABLAS

| First name | Last name |
| -- | -- |
| Max | Planck |
| Marie | Curie |

Left-aligned text | Center-aligned text | Right-aligned text
:-- | :--: | --:
Content | Content | Content

## MATEMÁTICAS (MathJax)

### Inline

This is an inline math expression $e^{2i\pi} = 1$.

### No inline

$$
\begin{vmatrix}a & b\\
c & d
\end{vmatrix}=ad-bc
$$
