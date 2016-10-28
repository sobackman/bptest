/*
 * generated by Xtext 2.9.2
 */
package org.xtuml.bp.xtext.masl.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xtuml.bp.xtext.masl.masl.structure.MaslModel
import org.xtuml.bp.xtext.masl.masl.structure.StructurePackage
import org.xtuml.bp.xtext.masl.services.MASLGrammarAccess

/** 
 * A very simple formatter
 */
class MASLFormatter extends AbstractFormatter2 {
	
	@Inject extension MASLGrammarAccess
	@Inject extension StructurePackage

	def dispatch void format(MaslModel maslModel, extension IFormattableDocument document) {
		maslModel.allRegionsFor.keywordPairs("is", "end").forEach [
			key.prepend[oneSpace; lowPriority].append[newLine; lowPriority]
			value.prepend[newLine; lowPriority]
			interior(key, value)[indent; lowPriority]
		]
		maslModel.allRegionsFor.keywordPairs("begin", "end").forEach [
			key.prepend[newLine; lowPriority].append[newLine; lowPriority]
			value.prepend[newLine; lowPriority]
			interior(key, value)[indent]
		]
		maslModel.allRegionsFor.keyword(';').append[newLine; lowPriority]
		maslModel.allRegionsFor.keyword('is').append[newLine; lowPriority]
		maslModel.allRegionsFor.keyword(pragmaAccess.pragmaKeyword_0).prepend[newLine]
	}
}
