	.file	"premierprogramme.c"
	.globl	variable_de_classe_externe_constante
	.section	.rodata
	.align 4
	.type	variable_de_classe_externe_constante, @object
	.size	variable_de_classe_externe_constante, 4
variable_de_classe_externe_constante:
	.long	1
	.comm	variable_de_classe_externe,4,4
.LC0:
	.string	"Hello wold"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	andl	$-16, %esp
	subl	$32, %esp
	movb	$65, 31(%esp)
	movl	$2, variable_de_classe_externe
	movl	$.LC0, (%esp)
	call	puts
	movsbl	31(%esp), %edx
	movl	variable_definie_ailleur, %eax
	addl	%eax, %edx
	movl	variable_de_classe_externe, %eax
	addl	%eax, %edx
	movl	variable_de_classe_externe_constante, %eax
	addl	%edx, %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (Debian 4.7.2-5) 4.7.2"
	.section	.note.GNU-stack,"",@progbits
